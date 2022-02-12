package com.ww.springbootlearn.controller.json;

import com.ww.springbootlearn.json.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * 测试日期json序列化、反序列化
 * @author wanggw
 * @date 2022-01-20 00:08:15
 */
@RestController
@RequestMapping("/msg")
public class MessagingRestController {

    private static final Logger logger = LoggerFactory.getLogger(MessagingRestController.class);

    @GetMapping("/getMessage")
    public Message getMessage() {
        Message message = new Message();
        message.setText("wanggw");
        message.setDate(LocalDate.parse("2022-01-19"));
        message.setTime(LocalTime.parse("01:12:18"));
        message.setTimestamp(LocalDateTime.parse("2019-12-31T23:59:59"));
        message.setDateUtil(new Date());

        return message;
    }

    @PostMapping("/submit")
    public String submitMsg(@RequestBody Message message) {
        logger.info("接收到message, {}", message);

        return "ok";
    }
}
