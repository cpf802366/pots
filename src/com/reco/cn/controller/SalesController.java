package com.reco.cn.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.reco.cn.constant.UserConstant;
import com.reco.cn.domain.*;
import com.reco.cn.service.*;
import com.reco.cn.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:38
 */

@Controller
@RequestMapping(" /sales")
public class SalesController {
    @Autowired
    private SalesService salesService;
    @Autowired
    private InfoService infoService;
    @Autowired
    private DesignService designService;
    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private MemAddrService memAddrService;
    @Autowired
    private OwnerService ownerService;
    @Autowired
    private PriceService priceService;

    @RequestMapping()
    String Sales() {
        return "cn/sales/sales";
    }

    @ResponseBody
    @RequestMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<SalesDO> salesList = salesService.list(query);
        int total = salesService.count(query);
        PageUtils pageUtils = new PageUtils(salesList, total);
        return pageUtils;
    }

    @RequestMapping("/add")
    ModelAndView add(HttpServletRequest request, Integer potId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/user/myhu");

        OwnerDO owner = ownerService.get(potId);
        InfoDO pot = infoService.get(potId);
        Object user = request.getSession().getAttribute(UserConstant.USER);

        //error data
        if (owner == null || pot == null || user == null)
            return mv;

        //error owner
        if ((long) owner.getOwner_id() != ((UserDO) user).getUser_id())
            return mv;

        //saled
        Map<String, Object> param = new HashMap<>();
        param.put("cxtj", "and complete_dttm is null and pot_id = " + potId);
        if (salesService.list(param).size() > 0)
            return mv;


        SalesDO d = new SalesDO();
        d.setDesignId(pot.getDesign_id());
        d.setPotId(pot.getPot_id());
        d.setPrice((float) 1);///////1 yuan for test
        d.setSellDttm(new Date());
        d.setSellMode(0);
        d.setSellerId(owner.getOwner_id());

        salesService.save(d);

        return mv;

    }

    @RequestMapping("/edit/{soId}")
    String edit(@PathVariable("soId") Integer soId, Model model) {
        SalesDO sales = salesService.get(soId);
        model.addAttribute("sales", sales);
        return "cn/sales/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    public R save(SalesDO sales) {
        if (salesService.save(sales) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(SalesDO sales) {
        salesService.update(sales);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/remove")
    @ResponseBody
    public R remove(Integer soId) {
        if (salesService.remove(soId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @RequestMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Integer[] soIds) {
        salesService.batchRemove(soIds);
        return R.ok();
    }

    @RequestMapping("/zffs/{id}/{pono}/{taken}")
    public ModelAndView zffs(@PathVariable("id") Integer id, @PathVariable("pono") String pono, @PathVariable("taken") boolean taken) {
        ModelAndView mv = new ModelAndView();
        MemAddrDO memAddrDO = memAddrService.get(id);
        PurchaseDO purchaseDO = new PurchaseDO();
        purchaseDO.setDelivery_addr(memAddrDO.getProvince() + memAddrDO.getCity() + memAddrDO.getArea() + memAddrDO.getJddz());
        purchaseDO.setPo_no(pono);
        purchaseDO.setTaken(taken);
        purchaseService.saveByNoAddr(purchaseDO);
        mv.addObject("pono", pono);
        mv.addObject("shdz", id);
        mv.setViewName("front/sales/saleszffs");
        return mv;
    }

    @RequestMapping("/zfzfb/{pono}")
    public void zfzfb(@PathVariable("pono") String pono, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        Map<String, Object> params = new HashMap<>();
        params.put("poNo", pono);

        List<PurchaseDO> list = purchaseService.list(params);
        PurchaseDO pur = list.get(0);
        String str = ZFBAlipay.AlipayUtil(pono, pur.getPrice().toString(), pur.getDesign_id().toString(), "");
        try {
            response.getWriter().write(str);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @RequestMapping("/zffshd")
    public ModelAndView zffshd(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        try {

            //获取支付宝GET过来反馈信息
            Map<String, String> params = new HashMap<String, String>();

            Map<String, String[]> requestParams = request.getParameterMap();
            for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
                String name = (String) iter.next();
                String[] values = (String[]) requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i]
                            : valueStr + values[i] + ",";
                }
                //乱码解决，这段代码在出现乱码时使用
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
                params.put(name, valueStr);
            }

            boolean signVerified = false; //调用SDK验证签名

            signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);


            //——请在这里编写您的程序（以下代码仅作参考）——
            if (signVerified) {
                //商户订单号
                String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

                //支付宝交易号
                String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

                //付款金额
                String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
//trade_no:2018042621001004910200385047<br/>out_trade_no:20180426021148<br/>total_amount:5000.00
                System.out.println("trade_no:" + trade_no + "<br/>out_trade_no:" + out_trade_no + "<br/>total_amount:" + total_amount);
                PurchaseDO purchaseDO = new PurchaseDO();
                purchaseDO.setPo_no(out_trade_no);
                purchaseDO.setPayment_mode("1");
                purchaseDO.setPayment_id(trade_no);

                Map<String, Object> param = new HashMap<>();
                param.put("po_no", purchaseDO.getPo_no());
                List<PurchaseDO> list = purchaseService.list(param);
                purchaseDO.setPo_id(list.get(0).getPo_id());
                purchaseService.update(purchaseDO);
                purchaseDO = purchaseService.get(list.get(0).getPo_id());
                //
                SalesDO salesDO = new SalesDO();
                salesDO.setSoId(Integer.parseInt(purchaseDO.getSo_ids()));
                SalesDO sales = salesService.get(salesDO.getSoId());
                sales.setCompleteDttm(new Date());
                sales.setPoIds(purchaseDO.getPo_id().toString());
                salesService.update(sales);

                OwnerDO ownerDO = new OwnerDO();
                ownerDO.setOwner_id(purchaseDO.getBuyer_id());
                ownerDO.setOwner_name(purchaseDO.getBuyer_name());
                ownerDO.setPrice(purchaseDO.getPrice());
                ownerDO.setPot_id(purchaseDO.getPot_id());
                ownerDO.setUpdate_date(new Date());
                ownerDO.setOrder_id(Integer.parseInt(purchaseDO.getSo_ids()));
                ownerDO.setTaken(purchaseDO.getTaken());
                ownerService.save(ownerDO);

                PriceDO priceDO = new PriceDO();

                priceDO.setPrice(purchaseDO.getPrice());
                priceDO.setDesignid(purchaseDO.getDesign_id());
                priceDO.setUpdatedate(new Date());
                priceDO.setUpdatetype("采购");
                priceDO.setUpdateinfo(purchaseDO.getPo_no());
                priceService.save(priceDO);
                mv.addObject("purchaes", purchaseDO);
                mv.setViewName("front/sales/zhifubaoPay");
                return mv;
            } else {
                System.out.println("验签失败");
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //——请在这里编写您的程序（以上代码仅作参考）——
        return null;
    }

}
