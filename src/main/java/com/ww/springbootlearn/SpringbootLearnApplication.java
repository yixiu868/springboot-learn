package com.ww.springbootlearn;

import com.ww.springbootlearn.contextinitializer.CustomContextInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootLearnApplication.class, args);

        // ApplicationContextInitializer加载方式1
//        SpringApplication springApplication = new SpringApplication(SpringbootLearnApplication.class);
//
//        // 手动加入
//        springApplication.addInitializers(new CustomContextInitializer());
//
//        // 启动Spring Boot
//        springApplication.run(args);
    }
}
