package com.ww.springbootlearn.anno.configproperties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaohua
 * @description 激活@ConfigurationProperties注解方法3
 * @date 2021-8-17 9:35
 */
@Configuration
@EnableConfigurationProperties({MailModuleProperties3.class})
@SuppressWarnings("unused")
public class PropertiesConfigMethod3 {
}
