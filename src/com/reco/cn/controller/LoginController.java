package com.reco.cn.controller;

import com.aliyuncs.exceptions.ClientException;
import com.reco.cn.author.AuthPermission;
import com.reco.cn.constant.UserConstant;
import com.reco.cn.domain.UserDO;
import com.reco.cn.service.UserService;
import com.reco.cn.sms.Sms;
import com.reco.cn.util.Md5Utils;
import com.reco.cn.util.R;
import com.reco.cn.util.RandomUtil;
import com.reco.cn.util.Resources;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by cpf on 2018/4/17.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/tologin")
    ModelAndView tologin(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("login/login");
        return mv;

    }

    @RequestMapping("/login")
    String login(HttpServletRequest request, UserDO userDO, HttpSession session) {

        String mv = null;
        if (userDO.getUsername() == null || userDO.getPassword() == null) {
            mv = "redirect:/login/tologin";

        } else {
            userDO.setPassword(Md5Utils.getMD5(userDO.getPassword()));
            UserDO userDOs = userService.getByUserDO(userDO);
            if (userDOs != null) {
                session.setAttribute(UserConstant.USER, userDOs);
                mv = "redirect:/login/usercenter";
                // mv.setViewName("front/user/usercenter");
            } else {
                mv = "redirect:/login/tologin";
            }
        }


        return mv;

    }


    @RequestMapping("/logout")
    String logout(HttpServletRequest request, UserDO userDO, HttpSession session) {
        String mv = null;
        session.removeAttribute(UserConstant.USER);
        mv = "redirect:/index";

        return mv;

    }


    @AuthPermission(validate=true)
    @RequestMapping("/usercenter")
    ModelAndView usercenter(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("front/user/usercenter");
        return mv;

    }

    @RequestMapping("/toregister")
    ModelAndView toregister(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("login/register");
        return mv;

    }

    @RequestMapping("/validate")
    ModelAndView validate(HttpServletRequest request, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        String uuid = (String) request.getParameter("uuid");
        String phone = (String) session.getAttribute(UserConstant.reguser + uuid);
        mv.addObject("uuid", uuid);
        mv.addObject("phone", phone);
        mv.setViewName("login/validate");
        return mv;

    }

    @RequestMapping("/register")
    @ResponseBody
    R register(HttpServletRequest request, UserDO userDO, HttpSession session) {
        String msg = "ok";
        String uuid = RandomUtil.createId();
        UserDO phone = new UserDO();
        phone.setMobile(userDO.getMobile());
        UserDO userDOs = userService.getByUserDO(phone);
        if (userDO.getName() == null || userDO.getName().length() == 0) {
            msg = "名称不能为空";
        } else if (userDO.getMobile().length() != 11) {
            msg = "手机位数不对";
        } else if (userDO.getPassword().length() < 6) {
            msg = "密码位数不能少于6位";
        } else if (userDOs != null) {
            msg = "手机号已被注册";
        } else if (StringUtils.isBlank(userDO.getEmail()) || !userDO.getEmail().contains("@")) {
            msg = "邮箱不能为空";
        }
        if (msg.equals("ok")) {

            String yzm = RandomUtil.generateVerifyCode(6, "0123456789");
            // MailService.注册(phone, yzm, email);

            session.setAttribute(uuid, yzm);
            session.setAttribute(UserConstant.reguser + uuid, userDO.getMobile());
            session.setAttribute(yzm, userDO);
            try {
                Sms.sendSms(userDO.getMobile(), yzm);

            } catch (ClientException e) {

                e.printStackTrace();
                R.error("验证码发送失败！");
            }
            return R.ok(uuid);
        }

        return R.error(msg);
    }

    @RequestMapping("/yzmyz")
    @ResponseBody
    R yzmyz(HttpServletRequest request, HttpSession session) {
        String uuid = (String) request.getParameter("uuid");
        String yzm = (String) request.getParameter("yzm");
        String orignyzm = (String) session.getAttribute(uuid);

        if (orignyzm.equals(yzm)) {
            UserDO userDO = (UserDO) session.getAttribute(orignyzm);

            int flag = userService.save(userDO);

            if (flag > -1) {
                session.setAttribute(UserConstant.USER, userDO);
                return R.ok();
            } else {
                return R.error("用户数据保存失败");
            }

        } else {
            return R.error("验证码错误");
        }


    }

    @RequestMapping("/againyzm")
    @ResponseBody
    R againyzm(HttpServletRequest request, HttpSession session) {
        String uuid = (String) request.getParameter("uuid");
        String orignyzm = (String) session.getAttribute(uuid);
        UserDO userDO = (UserDO) session.getAttribute(orignyzm);
        String yzm = RandomUtil.generateVerifyCode(6, "0123456789");
        try {
            Sms.sendSms(userDO.getMobile(), yzm);

        } catch (ClientException e) {
            e.printStackTrace();
            R.error("验证码发送失败！");
        }
        session.setAttribute(uuid, yzm);
        session.setAttribute(UserConstant.reguser + uuid, userDO.getMobile());
        session.setAttribute(yzm, userDO);
        return R.ok("验证码发送成功");


    }
}
