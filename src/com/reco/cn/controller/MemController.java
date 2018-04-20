package com.reco.cn.controller;

import com.reco.cn.domain.MemDO;
import com.reco.cn.service.MemService;
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
@RequestMapping("/cn/mem")
public class MemController {
    @Autowired
    private MemService memService;

    @RequestMapping()
    String Mem() {
        return "cn/mem/mem";
    }

    @ResponseBody
    @RequestMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<MemDO> memList = memService.list(query);
        int total = memService.count(query);
        PageUtils pageUtils = new PageUtils(memList, total);
        return pageUtils;
    }

    @RequestMapping("/add")
    String add() {
        return "cn/mem/add";
    }

    @RequestMapping("/edit/{id}")
    String edit(@PathVariable("id") Integer id, Model model) {
        MemDO mem = memService.get(id);
        model.addAttribute("mem", mem);
        return "cn/mem/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    public R save(MemDO mem) {
        if (memService.save(mem) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(MemDO mem) {
        memService.update(mem);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/remove")
    @ResponseBody
    public R remove(Integer id) {
        if (memService.remove(id) > 0) {
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
        memService.batchRemove(ids);
        return R.ok();
    }

}
