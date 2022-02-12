package com.ww.springbootlearn.anno.value;

import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author Administrator
 */
@PropertySource(value = { "" }, ignoreResourceNotFound = true)
public class User2 {

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
