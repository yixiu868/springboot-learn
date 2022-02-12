package com.ww.springbootlearn.anno.value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author xiaohua
 * @description TODO
 * @date 2021-8-17 10:51
 */
@SuppressWarnings("unused")
@Configuration
//@PropertySource(value = { "classpath:config.properties" }, ignoreResourceNotFound = true)
public class UserConfig {

    @Bean
    public User user() {
        return new User();
    }
}
