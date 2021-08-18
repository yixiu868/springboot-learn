package com.ww.springbootlearn.listener;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @author xiaohua
 * @description 自定义事件发布器
 * @date 2021-8-18 11:10
 */
@Component
public class CustomEventPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * 发布消息
     * 1、用户可以继承ApplicationEvent从而自定义Event类型
     * 2、也可以使用任意Object类型，但是如果event真实类型不是ApplicationEvent的话，那么event会被封装成PayloadApplicationEvent
     * @param msg
     */
    public void publishEvent(String msg) {
        System.out.println("发布者线程:" + Thread.currentThread().getName());
        applicationEventPublisher.publishEvent(msg);
    }
}
