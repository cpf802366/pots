package com.reco.cn.controller;

import com.reco.cn.domain.DictDO;
import com.reco.cn.service.DictService;
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
 * 字典表
 *
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:38
 */

@Controller
@RequestMapping("/cn/dict")
public class DictController {
    @Autowired
    private DictService dictService;

    @RequestMapping()
    String Dict() {
        return "cn/dict/dict";
    }

    @ResponseBody
    @RequestMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<DictDO> dictList = dictService.list(query);
        int total = dictService.count(query);
        PageUtils pageUtils = new PageUtils(dictList, total);
        return pageUtils;
    }

    @RequestMapping("/add")
    String add() {
        return "cn/dict/add";
    }

    @RequestMapping("/edit/{id}")
    String edit(@PathVariable("id") Long id, Model model) {
        DictDO dict = dictService.get(id);
        model.addAttribute("dict", dict);
        return "cn/dict/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    public R save(DictDO dict) {
        if (dictService.save(dict) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(DictDO dict) {
        dictService.update(dict);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/remove")
    @ResponseBody
    public R remove(Long id) {
        if (dictService.remove(id) > 0) {
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
        dictService.batchRemove(ids);
        return R.ok();
    }

}
