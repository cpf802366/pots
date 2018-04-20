package com.reco.cn.controller;

import com.reco.cn.constant.UserConstant;
import com.reco.cn.domain.*;
import com.reco.cn.service.*;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:39
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private DesignService designService;

    @Autowired
    private InfoService infoService;

    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping()
    String User() {
        return "/user";
    }

    @ResponseBody
    @RequestMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<UserDO> userList = userService.list(query);
        int total = userService.count(query);
        PageUtils pageUtils = new PageUtils(userList, total);
        return pageUtils;
    }

    @RequestMapping("/add")
    String add() {
        return "cn/user/add";
    }

    @RequestMapping("/edit/{userId}")
    String edit(@PathVariable("userId") Long userId, Model model) {
        UserDO user = userService.get(userId);
        model.addAttribute("user", user);
        return "cn/user/edit";
    }

    @RequestMapping("/dlaq")
    ModelAndView dlaq(HttpServletRequest request, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        UserDO uo = (UserDO) session.getAttribute(UserConstant.USER);
        if (uo == null || uo.getUsername() == null || uo.getPassword() == null) {
            mv.setViewName("redirect:/login/tologin");
            return mv;
        }
        mv.addObject("user", uo);
        mv.setViewName("front/user/userCenter_dlaq");
        return mv;
    }

    @RequestMapping("/myhu")
    ModelAndView myhu(HttpServletRequest request, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        UserDO uo = (UserDO) session.getAttribute(UserConstant.USER);
        if (uo == null || uo.getUsername() == null || uo.getPassword() == null) {
            mv.setViewName("redirect:/login/tologin");
            return mv;
        }

        List<MyhuDO> list = new ArrayList<MyhuDO>();

        Map<String, Object> q1 = new HashMap<String, Object>();
        q1.put("owner_id", uo.getUser_id());
        List<OwnerDO> ls1 = ownerService.list(q1);
        for (OwnerDO d : ls1) {
            MyhuDO myhu = new MyhuDO();
            myhu.setHisDOList(new ArrayList<MyhuHisDO>());

            InfoDO info = infoService.get(d.getPot_id());
            PurchaseDO po = purchaseService.get(d.getOrder_id());

            if (info != null) {
                myhu.setPot_id(info.getPot_id());
                myhu.setJdzh(info.getJdzh());

                DesignDO design = designService.get(info.getDesign_id());
                if (design != null) {
                    myhu.setDesign_Id(design.getDesign_Id());
                    myhu.setAuthor(design.getAuthor());
                    myhu.setArt_Id(design.getArt_Id());
                    myhu.setDesign_name(design.getName());
                    myhu.setDesign_img(design.getProductimg());
                }

                Map<String, Object> q2 = new HashMap<String, Object>();
                q2.put("pot_id", info.getPot_id());
                List<PurchaseDO> ls2 = purchaseService.list(q2);
                for (PurchaseDO poo : ls2) {
                    MyhuHisDO his = new MyhuHisDO();
                    his.setOwner_name(poo.getBuyer_name());
                    his.setPo_dttm_str(new SimpleDateFormat("yyyy-MM-dd").format(poo.getPo_dttm()));
                    his.setPo_price_str(new DecimalFormat("###,##0").format(poo.getPrice() / 10000));

                    myhu.getHisDOList().add(his);
                }
            }

            if (po != null) {
                myhu.setPo_no(po.getPo_no());
                myhu.setPo_dttm_str(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(po.getPo_dttm()));
                myhu.setPo_price_str(new DecimalFormat("###,##0").format(po.getPrice()));
                myhu.setTaken(po.getTaken());
            }


            list.add(myhu);
        }

        mv.addObject("myhuList", list);
        mv.setViewName("front/user/myhu");
        return mv;
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    public R save(UserDO user) {
        if (userService.save(user) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(UserDO user) {
        userService.update(user);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/remove")
    @ResponseBody
    public R remove(Long userId) {
        if (userService.remove(userId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @RequestMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Long[] userIds) {
        userService.batchRemove(userIds);
        return R.ok();
    }

}

