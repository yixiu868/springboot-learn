package com.ww.springbootlearn.anno.value;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @Configuration + @PropertySource + Environment
 * 加载配置文件helloworld.properties至Environment
 * @author Administrator
 */
@Configuration
@PropertySource("classpath:helloworld.properties")
public class User3Config {

    @SuppressWarnings("unused")
    @Autowired
    private Environment env;
}
