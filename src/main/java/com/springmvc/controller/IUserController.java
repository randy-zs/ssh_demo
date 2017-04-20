package com.springmvc.controller;

import com.springmvc.dao.impl.IUserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by randy on 17-4-20.
 */
@Controller
public class IUserController {

    private static final Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private IUserDaoImpl iUserDaoImpl;

    @RequestMapping(method = RequestMethod.GET, value = "/getRedis")
    public ModelAndView loginCheck(HttpServletRequest request) {
        logger.info(" # login check start.. ");
        ModelAndView mav = new ModelAndView();
        System.out.println(iUserDaoImpl.get("user1"));
        mav.setViewName("/successRedis");
        mav.addObject("user1", iUserDaoImpl.get("user1"));

        return mav;

    }

}
