package com.reco.cn.controller;

import com.reco.cn.domain.ArtDO;
import com.reco.cn.service.ArtService;
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
 * @date 2018-04-15 16:25:39
 */

@Controller
@RequestMapping("/cn/art")
public class ArtController {
    @Autowired
    private ArtService artService;

    @RequestMapping()
    String Art() {
        return "cn/art/art";
    }

    @ResponseBody
    @RequestMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ArtDO> artList = artService.list(query);
        int total = artService.count(query);
        PageUtils pageUtils = new PageUtils(artList, total);
        return pageUtils;
    }

    @RequestMapping("/add")
    String add() {
        return "cn/art/add";
    }

    @RequestMapping("/edit/{id}")
    String edit(@PathVariable("id") Integer id, Model model) {
        ArtDO art = artService.get(id);
        model.addAttribute("art", art);
        return "cn/art/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    public R save(ArtDO art) {
        if (artService.save(art) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(ArtDO art) {
        artService.update(art);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/remove")
    @ResponseBody
    public R remove(Integer id) {
        if (artService.remove(id) > 0) {
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
        artService.batchRemove(ids);
        return R.ok();
    }

}
