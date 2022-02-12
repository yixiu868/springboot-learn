package com.ww.springbootlearn.anno.configproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @description @PropertySource结合@ConfigurationProperties注解，可以读取主配置文件之外配置，赋值给类字段
 */
@Component
@PropertySource(value = { "classpath:config.properties" })
@ConfigurationProperties(prefix = "ww")
public class User3 {

    private String username;

    private String password;

    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
