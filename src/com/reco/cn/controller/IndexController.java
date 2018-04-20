package com.reco.cn.controller;

import com.reco.cn.domain.ArtDO;
import com.reco.cn.domain.DesignDO;
import com.reco.cn.service.ArtService;
import com.reco.cn.service.DesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private DesignService designService;
    @Autowired
    private ArtService artService;

    @RequestMapping()
    ModelAndView index(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        List<DesignDO> designlist = designService.list(null);
        Map<String, Object> expertmap = new HashMap<>();
        expertmap.put("is_exp", "1");
        List<ArtDO> expertlist = artService.list(expertmap);
        Map<String, Object> artmap = new HashMap<>();
        artmap.put("is_exp", "0");
        List<ArtDO> artlist = artService.list(artmap);
        mv.addObject("designlist", designlist);
        mv.addObject("artlist", artlist);
        mv.setViewName("front/index");
        return mv;

    }

    @RequestMapping("/pot")
    ModelAndView pot(HttpServletRequest request, Integer designId) {
        ModelAndView mv = new ModelAndView();
        DesignDO design = designService.get(designId);
        mv.addObject("design", design);
        mv.setViewName("front/pot/potdetail");
        return mv;

    }

    @RequestMapping("/jgjs")
    ModelAndView jgjs(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("front/indexmenu/jgjs");
        return mv;

    }

    @RequestMapping("/zsyr")
    ModelAndView zsyr(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        Map<String, Object> artmap = new HashMap<>();
        artmap.put("is_exp", "0");
        List<ArtDO> artlist = artService.list(artmap);

        mv.addObject("artlist", artlist);
        mv.setViewName("front/indexmenu/zsyr");
        return mv;

    }

    @RequestMapping("/zszj")
    ModelAndView zszj(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("front/indexmenu/zszj");
        return mv;

    }

    @RequestMapping("/zszp")
    ModelAndView zszp(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        List<DesignDO> designlist = designService.list(null);
        mv.addObject("designlist", designlist);
        mv.setViewName("front/indexmenu/zszp");
        return mv;

    }
}
