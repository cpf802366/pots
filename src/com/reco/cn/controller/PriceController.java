package com.reco.cn.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reco.cn.domain.PriceDO;
import com.reco.cn.service.PriceService;
import com.reco.cn.util.PageUtils;
import com.reco.cn.util.Query;
import com.reco.cn.util.R;
import com.reco.cn.util.ToolConverter;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:38
 */

@Controller
@RequestMapping("/price")
public class PriceController {
    @Autowired
    private PriceService priceService;

    @RequestMapping()
    String Price() {
        return "cn/price/price";
    }

    @ResponseBody
    @RequestMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<PriceDO> priceList = priceService.list(query);
        int total = priceService.count(query);
        PageUtils pageUtils = new PageUtils(priceList, total);
        return pageUtils;
    }
    @ResponseBody
    @RequestMapping("/listBydesignid")
    public void listBydesignid(String designid, HttpServletResponse response) {
        Map<String, Object> paramsp = new HashMap<>();
        paramsp.put("design_id",designid);
        paramsp.put("sort" ,"updatedate");
        paramsp.put("order" ,"asc");
        List<PriceDO> priceDOs = priceService.list(paramsp);
        ObjectMapper mapper = new ObjectMapper();    //提供java-json相互转换功能的类

        String json = null;    //将list中的对象转换为Json格式的数组
        try {
            json = mapper.writeValueAsString(priceDOs);
            //将json数据返回给客户端
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
    @RequestMapping("/add")
    String add() {
        return "cn/price/add";
    }

    @RequestMapping("/edit/{priceId}")
    String edit(@PathVariable("priceId") Integer priceId, Model model) {
        PriceDO price = priceService.get(priceId);
        model.addAttribute("price", price);
        return "cn/price/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    public R save(PriceDO price) {
        if (priceService.save(price) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(PriceDO price) {
        priceService.update(price);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/remove")
    @ResponseBody
    public R remove(Integer priceId) {
        if (priceService.remove(priceId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @RequestMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Integer[] priceIds) {
        priceService.batchRemove(priceIds);
        return R.ok();
    }

}
