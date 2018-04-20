package com.reco.cn.controller;

import com.reco.cn.domain.InfoDO;
import com.reco.cn.service.InfoService;
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
@RequestMapping("/cn/info")
public class InfoController {
    @Autowired
    private InfoService infoService;

    @RequestMapping()
    String Info() {
        return "cn/info/info";
    }

    @ResponseBody
    @RequestMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<InfoDO> infoList = infoService.list(query);
        int total = infoService.count(query);
        PageUtils pageUtils = new PageUtils(infoList, total);
        return pageUtils;
    }

    @RequestMapping("/add")
    String add() {
        return "cn/info/add";
    }

    @RequestMapping("/edit/{potId}")
    String edit(@PathVariable("potId") Integer potId, Model model) {
        InfoDO info = infoService.get(potId);
        model.addAttribute("info", info);
        return "cn/info/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    public R save(InfoDO info) {
        if (infoService.save(info) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(InfoDO info) {
        infoService.update(info);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/remove")
    @ResponseBody
    public R remove(Integer potId) {
        if (infoService.remove(potId) > 0) {
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
        infoService.batchRemove(potIds);
        return R.ok();
    }

}
