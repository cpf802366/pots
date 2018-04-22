package com.reco.cn.controller;

import com.reco.cn.domain.SalesDO;
import com.reco.cn.service.SalesService;
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
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:38
 */

@Controller
@RequestMapping(" /sales")
public class SalesController {
    @Autowired
    private SalesService salesService;

    @RequestMapping()
    String Sales() {
        return "cn/sales/sales";
    }

    @ResponseBody
    @RequestMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<SalesDO> salesList = salesService.list(query);
        int total = salesService.count(query);
        PageUtils pageUtils = new PageUtils(salesList, total);
        return pageUtils;
    }

    @RequestMapping("/add")
    String add() {
        return "cn/sales/add";
    }

    @RequestMapping("/edit/{soId}")
    String edit(@PathVariable("soId") Integer soId, Model model) {
        SalesDO sales = salesService.get(soId);
        model.addAttribute("sales", sales);
        return "cn/sales/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    public R save(SalesDO sales) {
        if (salesService.save(sales) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(SalesDO sales) {
        salesService.update(sales);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/remove")
    @ResponseBody
    public R remove(Integer soId) {
        if (salesService.remove(soId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @RequestMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Integer[] soIds) {
        salesService.batchRemove(soIds);
        return R.ok();
    }
    @RequestMapping("/zffs/{id}")
   public ModelAndView zffs(@PathVariable("id") Integer id){
       ModelAndView mv = new ModelAndView();
       mv.addObject("shdz",id);
       mv.setViewName("front/sales/saleszffs");
       return mv;
   }
}
