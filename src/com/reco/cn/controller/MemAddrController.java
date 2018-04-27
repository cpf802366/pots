package com.reco.cn.controller;

import com.reco.cn.constant.UserConstant;
import com.reco.cn.dao.DesignDao;
import com.reco.cn.domain.DesignDO;
import com.reco.cn.domain.MemAddrDO;
import com.reco.cn.domain.PurchaseDO;
import com.reco.cn.domain.UserDO;
import com.reco.cn.service.MemAddrService;
import com.reco.cn.service.PurchaseService;
import com.reco.cn.util.PageUtils;
import com.reco.cn.util.Query;
import com.reco.cn.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:39
 */

@Controller
@RequestMapping("/memAddr")
public class MemAddrController {
    @Autowired
    private MemAddrService memAddrService;
    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping()
    String MemAddr() {
        return "cn/memAddr/memAddr";
    }

    @ResponseBody
    @RequestMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<MemAddrDO> memAddrList = memAddrService.list(query);
        int total = memAddrService.count(query);
        PageUtils pageUtils = new PageUtils(memAddrList, total);
        return pageUtils;
    }

    @RequestMapping("/add")
    String add() {
        return "front/user/usershdz_add";
    }

    @RequestMapping("/edit/{id}")
    String edit(@PathVariable("id") Integer id, Model model) {
        MemAddrDO memAddr = memAddrService.get(id);
        model.addAttribute("memAddr", memAddr);
        return "front/user/usershdz_add";
    }

    /**
     * 保存
     */

    @RequestMapping("/save")
    public ModelAndView save(MemAddrDO memAddr, HttpSession session) {
        ModelAndView mv = new ModelAndView();

        if(memAddr.getId() != null && memAddr.getId() != 0){
            memAddrService.update(memAddr);
        }else{
            UserDO  userDao = (UserDO) session.getAttribute(UserConstant.USER);
            Integer userid =  userDao.getUser_id().intValue();
            memAddr.getUserid(userid );
            memAddrService.save(memAddr);
        }
   mv.setViewName("redirect:/memAddr/listByUser");

        return mv;
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(MemAddrDO memAddr) {
        memAddrService.update(memAddr);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/remove/{id}")

    public String remove(@PathVariable("id") Integer id) {
        memAddrService.remove(id)  ;


        return "redirect:/memAddr/listByUser";
    }

    /**
     * 删除
     */
    @RequestMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Integer[] ids) {
        memAddrService.batchRemove(ids);
        return R.ok();
    }

    @RequestMapping("/listByUser")
    public ModelAndView listByUser(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        //查询列表数据
        Map<String, Object> params = new HashMap<>();
        UserDO userDO = (UserDO) session.getAttribute(UserConstant.USER);
        params.put("userid", userDO.getUser_id());
        Query query = new Query(params);
        List<MemAddrDO> memAddrList = memAddrService.list(query);
        mv.addObject("memAddrList", memAddrList);
        mv.setViewName("front/user/usershdz");
        return mv;
    }

    /**
     * 删除
     */
    @RequestMapping("/defaultDz/{id}")

    public String defaultDz(@PathVariable("id") Integer id,HttpSession session) {
        UserDO userDO = (UserDO) session.getAttribute(UserConstant.USER);
        Map<String, Object> params = new HashMap<>();
        params.put("userid", userDO.getUser_id());
        Query query = new Query(params);
        memAddrService.defaultDz(id,query);
        return "redirect:/memAddr/listByUser";
    }

    @RequestMapping("/shdzselected/{designid}")
    public ModelAndView shdzselected(HttpSession session,@PathVariable("designid") Integer designid) {
        ModelAndView mv = new ModelAndView();
        UserDO userDO = (UserDO) session.getAttribute(UserConstant.USER);
        PurchaseDO purchaseDO = new PurchaseDO();
        purchaseDO.setBuyer_id( userDO.getUser_id().intValue());
        purchaseDO.setBuyer_name( userDO.getUsername());
        purchaseDO.setDesign_id(designid);
     R r =   purchaseService.savebyorder(purchaseDO);
        int  code  = (int) r.get("code");
        if(code == 0){
           mv.addObject("pono",r.get("msg"));
            Map<String, Object> params = new HashMap<>();

            params.put("userid", userDO.getUser_id());

            Query query = new Query(params);
            List<MemAddrDO> memAddrList = memAddrService.list(query);
            if (memAddrList != null && memAddrList.size()>0){
                mv.addObject("memAddrList", memAddrList);
                mv.setViewName("front/user/shdzselected");
            }else{
                mv.setViewName("redirect:listByUser");
            }
        }else{
            mv.addObject("error","暂时无法购买");
            mv.setViewName("front/pot/potdetail");
        }


        return mv;
    }
}
