# Spring Boot jar结构

`参考连接`

[Spring Boot Jar包启动实现](https://www.cnblogs.com/lifullmoon/p/14953064.html)

![spring-boot-jar-structure](img\spring-boot-jar-structure.png)

## 结构

* 1）BOOT-INF目录，里边保持了我们自己Spring Boot项目编译后的所有文件，其中classes目录下面就是.class文件，包括项目中的配置文件等，lib目录下就是我们引入的第三方依赖；
* 2）META-INF目录，通过MANIFEST.MF文件提供jar包的元数据，声明jar的启动类等信息。每个Java jar包应该都有这个文件，里边有一个`Main-Class`配置用于指定启动类。
* 3）org.springframework.boot.loader目录，也就是Spring Boot的spring-boot-loader工具模块，它就是java -jar xxx.jar启动Spring Boot项目的秘密所在，上面的Main-Class指定的就是该工具模块中的一个类。

### MANIFEST.MF

```java
Manifest-Version: 1.0
Implementation-Title: spring-boot-study
Implementation-Version: 1.0.0-SNAPSHOT
Built-By: jingping
Implementation-Vendor-Id: org.springframework.boot.demo
Spring-Boot-Version: 2.0.3.RELEASE
Main-Class: org.springframework.boot.loader.JarLauncher # spring-boot-loader 中的启动类
Start-Class: org.springframework.boot.demo.Application # 你的 Spring Boot 项目中的启动类
Spring-Boot-Classes: BOOT-INF/classes/ # 你的 Spring Boot 项目编译后的 .class 文件所在目录
Spring-Boot-Lib: BOOT-INF/lib/ # 你的 Spring Boot 项目所引入的第三方依赖所在目录
Created-By: Apache Maven 3.6.3
Build-Jdk: 1.8.0_251
Implementation-URL: https://projects.spring.io/spring-boot/#/spring-boot-starter-parent/info-dependencies/dwzq-info/info-stock-project/sp-provider
```

说明

* `Main-Class`：Java规定的jar包的启动类，这里设置为`spring-boot-loader`项目的`JarLauncher`类，进行Spring Boot应用的启动。

* `Start-Class`：Spring Boot规定的主启动类，这里通过Spring Boot Maven Plugin插件打包时，会设置为我们定义的Application启动类。

> 为什么不直接将我们的Application启动类设置为Main-Class启动呢？
>
> 因为通过Spring Boot Maven Plugin插件打包后的jar包，我们的.class文件在BOOT-INF/classes/目录下，在Java默认的jar包加载规则下找不到我们的Application启动类，也就需要通过JarLauncher启动加载。
>
> 当然，还有一个原因，Java规定可执行的jar包禁止嵌套其它jar包，在BOOT-INF/lib目录下我们Spring Boot应用依赖所有第三方jar包，因此spring-boot-loader项目自定义了ClassLoader实现类LaunchedURLClassLoader，支持加载BOOT-INF/classes目录下的.class文件，以及BOOT-INF/lib目录下的jar包。

## 启动过程

通过`Java -jar`启动应用时，根据`Main-Class`配置会调用org.springframework.boot.loader.JarLauncher的`main(String[])`方法；其中会先创建一个自定义的ClassLoader类加载器，可从`BOOT-INF`目录下加载出我们Spring Boot应用的Class类对象，包括依赖的第三方jar包中的Class类对象；然后根据`Start-Class`配置调用我们Spring Boot应用启动类的`main(String[])`方法（反射），这样也就启动了应用。
