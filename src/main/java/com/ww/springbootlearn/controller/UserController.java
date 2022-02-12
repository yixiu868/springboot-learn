package com.ww.springbootlearn.controller;

import com.ww.springbootlearn.anno.configproperties.User3;
import com.ww.springbootlearn.anno.value.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaohua
 * @description 测试@PropertySource与@Value
 * @date 2021-8-17 10:53
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private User user;

    @Autowired
    private User3 user3;

    @Autowired
    private Environment environment;

    @RequestMapping("/test01")
    public String test01() {
        logger.info("获取user信息");
        String obj = user.toString();
        logger.info("[用户信息]{}", user);
        return obj;
    }

    @RequestMapping("/user3")
    public String user3() {
        logger.info("获取user3信息");
        String obj = user3.toString();
        logger.info("[用户信息]{}", user3);
        return obj;
    }

    /**
     * 获取user4
     * 读取helloworld.properties配置testname=wanggw, testvalue=coder
     * @return
     */
    @RequestMapping("/user4")
    public String user4() {
        logger.info("获取user4");
        String testname = environment.getProperty("testname");
        String testvalue = environment.getProperty("testvalue");
        logger.info("读取helloworld.properties配置testname={}, testvalue={}", testname, testvalue);
        return testname + "," + testvalue;
    }
}
