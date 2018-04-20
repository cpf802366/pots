package com.reco.cn.controller;

import com.reco.cn.domain.RoleMenuDO;
import com.reco.cn.service.RoleMenuService;
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
 * 角色与菜单对应关系
 *
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:39
 */

@Controller
@RequestMapping("/cn/roleMenu")
public class RoleMenuController {
    @Autowired
    private RoleMenuService roleMenuService;

    @RequestMapping()
    String RoleMenu() {
        return "cn/roleMenu/roleMenu";
    }

    @ResponseBody
    @RequestMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<RoleMenuDO> roleMenuList = roleMenuService.list(query);
        int total = roleMenuService.count(query);
        PageUtils pageUtils = new PageUtils(roleMenuList, total);
        return pageUtils;
    }

    @RequestMapping("/add")
    String add() {
        return "cn/roleMenu/add";
    }

    @RequestMapping("/edit/{id}")
    String edit(@PathVariable("id") Long id, Model model) {
        RoleMenuDO roleMenu = roleMenuService.get(id);
        model.addAttribute("roleMenu", roleMenu);
        return "cn/roleMenu/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    public R save(RoleMenuDO roleMenu) {
        if (roleMenuService.save(roleMenu) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(RoleMenuDO roleMenu) {
        roleMenuService.update(roleMenu);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/remove")
    @ResponseBody
    public R remove(Long id) {
        if (roleMenuService.remove(id) > 0) {
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
        roleMenuService.batchRemove(ids);
        return R.ok();
    }

}
