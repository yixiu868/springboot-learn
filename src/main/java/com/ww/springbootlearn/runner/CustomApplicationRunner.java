package com.ww.springbootlearn.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author xiaohua
 * @description 自定义ApplicationRunner实现类
 * @date 2021-8-19 0:07
 */
@Component
@Order(value = -1)
public class CustomApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("调用自定义ApplicationRunner...");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }
}
