package com.ww.springbootlearn.anno.value;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author xiaohua
 * @description TODO
 * @date 2021-8-17 10:49
 */
public class User {

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @Value("${age}")
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
