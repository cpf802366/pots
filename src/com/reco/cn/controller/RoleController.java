package com.reco.cn.controller;

import com.reco.cn.domain.RoleDO;
import com.reco.cn.service.RoleService;
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
 * 角色
 *
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:39
 */

@Controller
@RequestMapping("/cn/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping()
    String Role() {
        return "cn/role/role";
    }

    @ResponseBody
    @RequestMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<RoleDO> roleList = roleService.list(query);
        int total = roleService.count(query);
        PageUtils pageUtils = new PageUtils(roleList, total);
        return pageUtils;
    }

    @RequestMapping("/add")
    String add() {
        return "cn/role/add";
    }

    @RequestMapping("/edit/{roleId}")
    String edit(@PathVariable("roleId") Long roleId, Model model) {
        RoleDO role = roleService.get(roleId);
        model.addAttribute("role", role);
        return "cn/role/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    public R save(RoleDO role) {
        if (roleService.save(role) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(RoleDO role) {
        roleService.update(role);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/remove")
    @ResponseBody
    public R remove(Long roleId) {
        if (roleService.remove(roleId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @RequestMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Long[] roleIds) {
        roleService.batchRemove(roleIds);
        return R.ok();
    }

}
