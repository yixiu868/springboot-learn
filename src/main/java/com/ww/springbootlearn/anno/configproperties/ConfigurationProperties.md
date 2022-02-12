# @ConfigurationProperties注解

`参考连接`

[@ConfigurationProperties 注解使用姿势，这一篇就够了](https://www.cnblogs.com/jimoer/p/11374229.html)

@ConfigurationProperties是SpringBoot中注解，用于将主配置文件(application.properties或application.yml)中的属性，映射到实体类中对应的属性。意思是把主配置文件中配置属性设置到对应的Bean属性上。

## 基本用法

为每个需要捕获的外部属性提供一个带有字段的类。

* 1）前缀定义哪些外部属性将绑定到类的字段上；

* 2）根据Spring Boot宽松的绑定规则，类的属性名必须与外部属性名匹配；

  ```java
  mail.hostName=localhost
  mail.hostname=localhost
  mail.host_name=localhost
  mail.host-name=localhost
  mail.HOST_NAME=localhost
  ```

  

* 3）简单用一个值初始化一个字段来定义一个默认值；

* 4）类本身可以是包私有的；

* 5）类的字段必须有公共setter方法；

## 复杂属性类型

### List和Set

```java
@Component
@ConfigurationProperties(prefix = "myapp.mail")
public class MailModuleProperties {
    
    private List<String> smtpServers;
}
```

在application.properties文件中以数组形式书写

```properties
myapp.mail.smtpServers[0]=server1
myapp.mail.smtpServers[1]=server2
```

在application.yml文件中添加如下：

```yaml
myapp:
	mail:
		smtp-servers:
			- server1
			- server2
```

## 激活方式

* 激活方式1

  ```java
  // 注释激活方式1、激活方式2
  com.ww.springbootlearn.model.anno.configurationproperties.MailModuleProperties
  ```

* 激活方式2

  ```java
  /**
   * 使用时，注释方法2
   * 注释方法1中@Component
   */
  
  com.ww.springbootlearn.model.anno.configurationproperties.PropertiesConfig
  ```

* 激活方式3

  ```java
  /**
   * 使用时，注释方法3
   * 注释方法1中@Component
   */
  
  com.ww.springbootlearn.model.anno.configurationproperties.PropertiesConfigMethod3
  ```
  

## 优点

* 1、可以直接为一个类的多个字段进行赋值；

## 与@PropertySource结合

默认@ConfigurationProperties只能从主配置文件读取属性，集合@PropertySource可以从指定配置文件读取属性值。
