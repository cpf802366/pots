package com.reco.cn.controller;

import com.reco.cn.domain.OwnerDO;
import com.reco.cn.service.OwnerService;
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

import java.util.List;
import java.util.Map;

/**
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:38
 */

@Controller
@RequestMapping("/cn/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @RequestMapping()
    String Owner() {
        return "cn/owner/owner";
    }

    @ResponseBody
    @RequestMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<OwnerDO> ownerList = ownerService.list(query);
        int total = ownerService.count(query);
        PageUtils pageUtils = new PageUtils(ownerList, total);
        return pageUtils;
    }

    @RequestMapping("/add")
    String add() {
        return "cn/owner/add";
    }

    @RequestMapping("/edit/{potId}")
    String edit(@PathVariable("potId") Integer potId, Model model) {
        OwnerDO owner = ownerService.get(potId);
        model.addAttribute("owner", owner);
        return "cn/owner/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    public R save(OwnerDO owner) {
        if (ownerService.save(owner) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(OwnerDO owner) {
        ownerService.update(owner);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/remove")
    @ResponseBody
    public R remove(Integer potId) {
        if (ownerService.remove(potId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @RequestMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Integer[] potIds) {
        ownerService.batchRemove(potIds);
        return R.ok();
    }

}
