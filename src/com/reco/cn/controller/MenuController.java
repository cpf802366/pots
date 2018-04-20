package com.reco.cn.controller;

import com.reco.cn.domain.MenuDO;
import com.reco.cn.service.MenuService;
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
 * 菜单管理
 *
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:39
 */

@Controller
@RequestMapping("/cn/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping()
    String Menu() {
        return "cn/menu/menu";
    }

    @ResponseBody
    @RequestMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<MenuDO> menuList = menuService.list(query);
        int total = menuService.count(query);
        PageUtils pageUtils = new PageUtils(menuList, total);
        return pageUtils;
    }

    @RequestMapping("/add")
    String add() {
        return "cn/menu/add";
    }

    @RequestMapping("/edit/{menuId}")
    String edit(@PathVariable("menuId") Long menuId, Model model) {
        MenuDO menu = menuService.get(menuId);
        model.addAttribute("menu", menu);
        return "cn/menu/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    public R save(MenuDO menu) {
        if (menuService.save(menu) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(MenuDO menu) {
        menuService.update(menu);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/remove")
    @ResponseBody
    public R remove(Long menuId) {
        if (menuService.remove(menuId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @RequestMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Long[] menuIds) {
        menuService.batchRemove(menuIds);
        return R.ok();
    }

}
