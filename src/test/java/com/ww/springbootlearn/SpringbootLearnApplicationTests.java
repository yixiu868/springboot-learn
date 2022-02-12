package com.ww.springbootlearn;

import com.ww.springbootlearn.listener.CustomEventPublisher;
import com.ww.springbootlearn.listener.NotifyEvent;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@SuppressWarnings("unused")
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootLearnApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void testListener() {
//        NotifyEvent event = new NotifyEvent("hello, how are you", "abc@google.com", "hello");
//        webApplicationContext.publishEvent(event);

        CustomEventPublisher publisher = webApplicationContext.getBean(CustomEventPublisher.class);
        publisher.publishEvent("自定义事件发布器");
    }
}
