package com.reco.cn.controller;

import com.reco.cn.domain.PurchaseDO;
import com.reco.cn.service.PurchaseService;
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
@RequestMapping("/cn/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping()
    String Purchase() {
        return "cn/purchase/purchase";
    }

    @ResponseBody
    @RequestMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<PurchaseDO> purchaseList = purchaseService.list(query);
        int total = purchaseService.count(query);
        PageUtils pageUtils = new PageUtils(purchaseList, total);
        return pageUtils;
    }

    @RequestMapping("/add")
    String add() {
        return "cn/purchase/add";
    }

    @RequestMapping("/edit/{poId}")
    String edit(@PathVariable("poId") Integer poId, Model model) {
        PurchaseDO purchase = purchaseService.get(poId);
        model.addAttribute("purchase", purchase);
        return "cn/purchase/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    public R save(PurchaseDO purchase) {
        if (purchaseService.save(purchase) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(PurchaseDO purchase) {
        purchaseService.update(purchase);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/remove")
    @ResponseBody
    public R remove(Integer poId) {
        if (purchaseService.remove(poId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @RequestMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Integer[] poIds) {
        purchaseService.batchRemove(poIds);
        return R.ok();
    }

}
