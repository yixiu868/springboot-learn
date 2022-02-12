package com.ww.springbootlearn.controller;

import com.ww.springbootlearn.anno.configproperties.MailModuleProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaohua
 * @description @ConfigurationProperties几种配置方式测试
 * @date 2021-8-17 9:52
 */
@RequestMapping("/conf")
@RestController
public class MailConfigController {

    private static final Logger logger = LoggerFactory.getLogger(MailConfigController.class);

    @Autowired
    private MailModuleProperties mailModuleProperties;

    @RequestMapping("/mail")
    public String mailConf() {
        logger.info("邮件配置");
        String detail = mailModuleProperties.toString();
        logger.info("【邮件信息】{}", detail);
        return detail;
    }

    @RequestMapping("/mail2")
    public String mailConf2() {
        logger.info("邮件配置");
        String detail = mailModuleProperties.toString();
        logger.info("【邮件信息】{}", detail);
        return detail;
    }

    @RequestMapping("/mail3")
    public String mailConf3() {
        logger.info("邮件配置");
        String detail = mailModuleProperties.toString();
        logger.info("【邮件信息】{}", detail);
        return detail;
    }
}
