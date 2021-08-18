# @ConfigurationProperties注解

`参考连接`

[[@ConfigurationProperties 注解使用姿势，这一篇就够了](https://www.cnblogs.com/jimoer/p/11374229.html)](https://www.cnblogs.com/jimoer/p/11374229.html)

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

## 激活方式

* 激活方式1

  ```java
  com.ww.springbootlearn.model.anno.configurationproperties.MailModuleProperties
  ```

* 激活方式2

  ```java
  com.ww.springbootlearn.model.anno.configurationproperties.PropertiesConfig
  ```

* 激活方式3

  ```java
  com.ww.springbootlearn.model.anno.configurationproperties.PropertiesConfigMethod3
  ```

  

