package com.ww.springbootlearn.contextinitializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

/**
 * @author xiaohua
 * @description 自定义ApplicationContextInitializer实现
 * @date 2021-8-18 13:08
 */
@SuppressWarnings("rawtypes")
@Order(111)
public class CustomContextInitializer implements ApplicationContextInitializer {
    
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("容器中bean数量:" + applicationContext.getBeanDefinitionCount());
        System.out.println(applicationContext.getBeanDefinitionCount() + "个Bean的名字如下：");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println(beanName);
        }
    }
}
