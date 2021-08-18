package com.ww.springbootlearn.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @author xiaohua
 * @description 自定义事件监听器
 * @date 2021-8-18 11:13
 */
@Component
public class CustomEventListener implements ApplicationListener<PayloadApplicationEvent<String>> {
    
    @Override
    public void onApplicationEvent(PayloadApplicationEvent<String> event) {
        String msg = event.getPayload();
        System.out.println("监听器线程名:" + Thread.currentThread().getName());
        System.out.println("自定义监听器接收到消息:" + msg);
    }
}
