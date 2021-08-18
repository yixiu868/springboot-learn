# ApplicationContextInitializer实现与使用

参考链接

[[spring扩展点之五：ApplicationContextInitializer实现与使用](https://www.cnblogs.com/duanxz/p/11239291.html)](https://www.cnblogs.com/duanxz/p/11239291.html)

## 作用

主要在Spring refresh之前，允许我们对ConfigurableApplicationContext的实例做进一步的设置和处理。

### 典型应用场景

Web应用中需要编程方式对应用上下文做初始化。比如，注册属性源(property source)或者针对上下文的环境信息environment激活相应的profile。

在一个Spring Boot应用中，classpath上会包含很多jar包，有些jar包需要在ConfigurableApplicationContext#refresh()调用之前对应用上下文做一些初始化动作，需要提供自己的ApplicationContextInitializer实现类，然后放在自己的META-INF/spring.factories属性文件中，这样相应的ApplicationContextInitializer实现类就会被`SpringApplication#initialize`发现。

## 三种加载方式

// TODO 链接有提供，MD文档待补充。
