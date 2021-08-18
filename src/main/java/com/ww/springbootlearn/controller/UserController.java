package com.ww.springbootlearn.controller;

import com.ww.springbootlearn.model.anno.value.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xiaohua
 * @description 测试@PropertySource与@Value
 * @date 2021-8-17 10:53
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private User user;

    @RequestMapping("/test01")
    @ResponseBody
    public String test01() {
        logger.info("获取user信息");
        String obj = user.toString();
        logger.info("[用户信息]{}", user);
        return obj;
    }
}
