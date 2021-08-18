package com.ww.springbootlearn.controller;

import com.ww.springbootlearn.model.anno.configurationproperties.MailModuleProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xiaohua
 * @description @ConfigurationProperties几种配置方式测试
 * @date 2021-8-17 9:52
 */
@RequestMapping("/conf")
@Controller
public class MailConfigController {

    private static final Logger logger = LoggerFactory.getLogger(MailConfigController.class);

    @Autowired
    private MailModuleProperties mailModuleProperties;

    @RequestMapping("/mail")
    @ResponseBody
    public String mailConf() {
        logger.info("邮件配置");
        String detail = mailModuleProperties.toString();
        logger.info("【邮件信息】{}", detail);
        return detail;
    }
}
