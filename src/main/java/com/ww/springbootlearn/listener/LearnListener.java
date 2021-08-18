package com.ww.springbootlearn.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author xiaohua
 * @description 事件监听器
 * @date 2021-8-18 10:44
 */
@Component
public class LearnListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // 打印容器中Bean数量
        System.out.println("***************************************");
        System.out.println("容器中初始化Bean数量:" + event.getApplicationContext().getBeanDefinitionCount());
        System.out.println("***************************************");
    }
}
