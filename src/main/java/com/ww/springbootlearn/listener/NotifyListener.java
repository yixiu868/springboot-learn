package com.ww.springbootlearn.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author xiaohua
 * @description 自定义监听器
 * @date 2021-8-18 10:51
 */
@Component
public class NotifyListener implements ApplicationListener<NotifyEvent> {

    @Override
    public void onApplicationEvent(NotifyEvent event) {
        System.out.println("*****************************************");
        System.out.println("邮箱地址：" + event.getEmail());
        System.out.println("邮件内容：" + event.getContent());
        System.out.println("*****************************************");
    }
}
