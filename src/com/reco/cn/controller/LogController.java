package com.reco.cn.controller;

import com.reco.cn.domain.LogDO;
import com.reco.cn.service.LogService;
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
 * 系统日志
 *
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:38
 */

@Controller
@RequestMapping("/cn/log")
public class LogController {
    @Autowired
    private LogService logService;

    @RequestMapping()
    String Log() {
        return "cn/log/log";
    }

    @ResponseBody
    @RequestMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<LogDO> logList = logService.list(query);
        int total = logService.count(query);
        PageUtils pageUtils = new PageUtils(logList, total);
        return pageUtils;
    }

    @RequestMapping("/add")
    String add() {
        return "cn/log/add";
    }

    @RequestMapping("/edit/{id}")
    String edit(@PathVariable("id") Long id, Model model) {
        LogDO log = logService.get(id);
        model.addAttribute("log", log);
        return "cn/log/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    public R save(LogDO log) {
        if (logService.save(log) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(LogDO log) {
        logService.update(log);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/remove")
    @ResponseBody
    public R remove(Long id) {
        if (logService.remove(id) > 0) {
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
        logService.batchRemove(ids);
        return R.ok();
    }

}
