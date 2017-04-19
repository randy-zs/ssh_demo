package com.springmvc.controller;

import com.springmvc.dto.User;
import com.springmvc.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by randy on 17-2-21.
 */
@Controller
public class LoginController {

    private static final Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        logger.info(" 你已通过springMVC进入controller方法。。。。 ");
        logger.info(" first java class");
        logger.info(" 北风呼呼地刮 雪花飘飘洒洒 ");
        logger.info(" 突然传来了一声枪响 ");
        logger.info(" 这匹狼它受了重伤 ");
        logger.info(" 但它侥幸逃脱了 ");
        logger.info(" 救它的是一只羊 ");
        logger.info(" 从此它们约定三生 互诉着衷肠 ");
        logger.info(" 狼说亲爱的 ");
        logger.info(" 谢谢你为我疗伤 ");
        logger.info(" 不管未来有多少的风雨 ");
        logger.info(" 我都为你去扛 ");
        logger.info(" 羊说不要客气 ");
        logger.info(" 谁让我爱上了你 ");
        logger.info(" 在你身边有多么的危险 ");
        logger.info(" 我都会陪伴你 ");
        logger.info(" 就这样 它们快乐地流浪 ");
        logger.info(" 就这样 它们为爱歌唱 ");
        logger.info(" ........ end ........ ");

        // 这个是映射 WEB-INF.page.index.jsp 而不是 webapp.index.jsp
        request.setAttribute("userList", userService.getAllUser());

        return "/index";
    }

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login/check")
    public ModelAndView loginCheck(HttpServletRequest request, User user) {
        logger.info(" # login check start.. ");
        ModelAndView mav = new ModelAndView();

        if(!userService.login(user.getUserName(), user.getPassword())) {
            mav.setViewName("/login");
            mav.addObject("errorMsg", "用户名或密码错误！");
        } else {
            mav.setViewName("/success");
            mav.addObject("user", user);
        }
        return mav;

    }
}
