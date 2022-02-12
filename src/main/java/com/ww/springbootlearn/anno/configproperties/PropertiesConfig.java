package com.ww.springbootlearn.anno.configproperties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaohua
 * @description 激活@ConfigurationProperties方法2
 * @date 2021-8-17 9:32
 */
@SuppressWarnings("unused")
@Configuration
public class PropertiesConfig {

    @Bean
    public MailModuleProperties2 mailModuleProperties2() {
        return new MailModuleProperties2();
    }
}
