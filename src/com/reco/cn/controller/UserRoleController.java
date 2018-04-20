package com.reco.cn.controller;

import com.reco.cn.domain.UserRoleDO;
import com.reco.cn.service.UserRoleService;
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
 * 用户与角色对应关系
 *
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:39
 */

@Controller
@RequestMapping("/cn/userRole")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping()
    String UserRole() {
        return "cn/userRole/userRole";
    }

    @ResponseBody
    @RequestMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<UserRoleDO> userRoleList = userRoleService.list(query);
        int total = userRoleService.count(query);
        PageUtils pageUtils = new PageUtils(userRoleList, total);
        return pageUtils;
    }

    @RequestMapping("/add")
    String add() {
        return "cn/userRole/add";
    }

    @RequestMapping("/edit/{id}")
    String edit(@PathVariable("id") Long id, Model model) {
        UserRoleDO userRole = userRoleService.get(id);
        model.addAttribute("userRole", userRole);
        return "cn/userRole/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    public R save(UserRoleDO userRole) {
        if (userRoleService.save(userRole) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(UserRoleDO userRole) {
        userRoleService.update(userRole);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/remove")
    @ResponseBody
    public R remove(Long id) {
        if (userRoleService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @RequestMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Long[] ids) {
        userRoleService.batchRemove(ids);
        return R.ok();
    }

}
