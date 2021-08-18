package com.ww.springbootlearn.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author xiaohua
 * @description 自定义CommandLineRunner实现类
 * @date 2021-8-18 23:56
 */
@Order(value = 1)
@Component
public class CustomCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("*********************************");
        System.out.println("开始调用自定义CommandLineRunner...");
        System.out.println("*********************************");
    }
}
