package com.ww.springbootlearn.anno.configproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author xiaohua
 * @description @ConfigurationProperties注解使用学习
 * 只有当类所在的Spring @ComponentScan注解扫描到才会生效
 * @date 2021-8-17 9:26
 */
@ConfigurationProperties(prefix = "myapp.mail")
public class MailModuleProperties2 {

    private Boolean enabled = Boolean.TRUE;

    private String defaultSubject;

    private List<String> smtpServers;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getDefaultSubject() {
        return defaultSubject;
    }

    public void setDefaultSubject(String defaultSubject) {
        this.defaultSubject = defaultSubject;
    }

    public List<String> getSmtpServers() {
        return smtpServers;
    }

    public void setSmtpServers(List<String> smtpServers) {
        this.smtpServers = smtpServers;
    }

    @Override
    public String toString() {
        return "MailModuleProperties{" +
                "enabled=" + enabled +
                ", defaultSubject='" + defaultSubject + '\'' +
                ", smtpServers=" + smtpServers +
                '}';
    }
}
