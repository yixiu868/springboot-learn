package com.ww.springbootlearn.runlistener;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author xiaohua
 * @description 自定义SpringApplicationRunListener接口实现
 * @date 2021-8-18 15:15
 */
public class CustomSpringApplicationRunListener implements SpringApplicationRunListener {

    @SuppressWarnings("unused")
	private final SpringApplication springApplication;

    @SuppressWarnings("unused")
	private final String[] args;

    public CustomSpringApplicationRunListener(SpringApplication springApplication, String[] args) {
        this.springApplication = springApplication;
        this.args = args;
    }

    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        System.out.println("自定义starting");
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        System.out.println("自定义environmentPrepared");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("自定义contextPrepared");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("自定义contextLoaded");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("自定义running");
    }
}
