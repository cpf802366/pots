package com.reco.cn.controller;

import com.reco.cn.domain.PriceDO;
import com.reco.cn.service.PriceService;
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
@RequestMapping("/cn/price")
public class PriceController {
    @Autowired
    private PriceService priceService;

    @RequestMapping()
    String Price() {
        return "cn/price/price";
    }

    @ResponseBody
    @RequestMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<PriceDO> priceList = priceService.list(query);
        int total = priceService.count(query);
        PageUtils pageUtils = new PageUtils(priceList, total);
        return pageUtils;
    }

    @RequestMapping("/add")
    String add() {
        return "cn/price/add";
    }

    @RequestMapping("/edit/{priceId}")
    String edit(@PathVariable("priceId") Integer priceId, Model model) {
        PriceDO price = priceService.get(priceId);
        model.addAttribute("price", price);
        return "cn/price/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    public R save(PriceDO price) {
        if (priceService.save(price) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(PriceDO price) {
        priceService.update(price);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/remove")
    @ResponseBody
    public R remove(Integer priceId) {
        if (priceService.remove(priceId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @RequestMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Integer[] priceIds) {
        priceService.batchRemove(priceIds);
        return R.ok();
    }

}
