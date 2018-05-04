package com.reco.cn.controller;

import com.reco.cn.domain.DesignDO;
import com.reco.cn.domain.PriceDO;
import com.reco.cn.domain.SalesDO;
import com.reco.cn.service.DesignService;
import com.reco.cn.service.PriceService;
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

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cpf
 * @email mcpfzt@163.com
 * @date 2018-04-15 16:25:38
 */

@Controller
@RequestMapping("/design")
public class DesignController {
    @Autowired
    private DesignService designService;
    @Autowired
    private SalesService salesService;
    @Autowired
    private PriceService priceService;
    @RequestMapping()
    ModelAndView design(HttpServletRequest request, Integer designId) {
        ModelAndView mv = new ModelAndView();
        DesignDO design = designService.get(designId);

        Map<String, Object> params = new HashMap<>();
        params.put("cxtj","and complete_dttm  is null");
        params.put("sort" ,"sell_dttm");
        params.put("order" ,"asc");
        List<SalesDO> salesDOs = salesService.list(params);
        if (salesDOs != null && salesDOs.size()>0){
            mv.addObject("sales", salesDOs.get(0));
        }

        mv.addObject("design", design);
        mv.setViewName("front/pot/potdetail");
        return mv;

    }


    @ResponseBody
    @RequestMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<DesignDO> designList = designService.list(query);
        int total = designService.count(query);
        PageUtils pageUtils = new PageUtils(designList, total);
        return pageUtils;
    }

    @RequestMapping("/add")
    String add() {
        return "cn/design/add";
    }

    @RequestMapping("/edit/{designId}")
    String edit(@PathVariable("designId") Integer designId, Model model) {
        DesignDO design = designService.get(designId);
        model.addAttribute("design", design);
        return "cn/design/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    public R save(DesignDO design) {
        if (designService.save(design) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(DesignDO design) {
        designService.update(design);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/remove")
    @ResponseBody
    public R remove(Integer designId) {
        if (designService.remove(designId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @RequestMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Integer[] designIds) {
        designService.batchRemove(designIds);
        return R.ok();
    }

}
