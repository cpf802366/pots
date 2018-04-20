package com.reco.cn.controller;

import com.reco.cn.constant.UserConstant;
import com.reco.cn.domain.MemAddrDO;
import com.reco.cn.domain.UserDO;
import com.reco.cn.service.MemAddrService;
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
        return "cn/memAddr/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    public R save(MemAddrDO memAddr) {
        if (memAddrService.save(memAddr) > 0) {
            return R.ok();
        }
        return R.error();
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
    @RequestMapping("/remove")
    @ResponseBody
    public R remove(Integer id) {
        if (memAddrService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
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
}
