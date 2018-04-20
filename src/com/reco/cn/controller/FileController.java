package com.reco.cn.controller;

import com.reco.cn.domain.FileDO;
import com.reco.cn.service.FileService;
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
 * 文件上传
 *
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:38
 */

@Controller
@RequestMapping("/cn/file")
public class FileController {
    @Autowired
    private FileService fileService;

    @RequestMapping()
    String File() {
        return "cn/file/file";
    }

    @ResponseBody
    @RequestMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<FileDO> fileList = fileService.list(query);
        int total = fileService.count(query);
        PageUtils pageUtils = new PageUtils(fileList, total);
        return pageUtils;
    }

    @RequestMapping("/add")
    String add() {
        return "cn/file/add";
    }

    @RequestMapping("/edit/{id}")
    String edit(@PathVariable("id") Long id, Model model) {
        FileDO file = fileService.get(id);
        model.addAttribute("file", file);
        return "cn/file/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    public R save(FileDO file) {
        if (fileService.save(file) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(FileDO file) {
        fileService.update(file);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/remove")
    @ResponseBody
    public R remove(Long id) {
        if (fileService.remove(id) > 0) {
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
        fileService.batchRemove(ids);
        return R.ok();
    }

}
