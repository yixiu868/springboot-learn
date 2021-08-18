# springboot-learn

## 自动配置

### 自动配置中使用的条件化注解

| 条件化注解                      | 配置生效条件                                                 |
| ------------------------------- | ------------------------------------------------------------ |
| @ConditionalOnBean              | 配置了某个特定Bean                                           |
| @ConditionalOnMissingBean       | 没有配置特定的Bean                                           |
| @ConditionalOnClass             | Classpath里有指定的类                                        |
| @ConditionalOnMissingClass      | Classpath里缺少指定的类                                      |
| @ConditionalOnExpression        | 给定的Spring Expression Language表达式计算结果为true         |
| @ConditionalOnJava              | Java的版本匹配特定值或者一个范围值                           |
| @ConditionalOnJndi              | 参数中给定的JNDI位置必须存在一个，如果没有给参数，则要给JNDI InitialContext |
| @ConditionalOnProperty          | 指定的配置属性要有一个明确的值                               |
| @ConditionalOnResource          | Classpath里有指定的资源                                      |
| @ConditionalOnWebApplication    | 这是一个Web应用程序                                          |
| @ConditionalOnNotWebApplication | 这不是一个Web应用程序                                        |

## Spring Boot属性加载优先级

`优先级从高到低`

* 1）`命令行参数`；
* 2）JVM系统属性；
* 3）操作系统环境变量；
* 4）`应用程序以外的`application.properties或者application.yml文件；
* 5）打包在`应用程序内的`application.properties或者application.yml文件；
* 6）通过`@PropertySource`标注的属性源；
* 7）默认属性；

### application.properties和application.yml放置位置

`优先级从高到低`

* 1）外置，在相对于应用程序运行目录的/config子目录里
* 2）外置，在应用程序运行的目录里；
* 3）内置，在config包内；
* 4）内置，在Classpath根目录；

`如果你在同一个优先级位置同时有application.properties和application.yml，那么application.yml属性会覆盖application.properties里的属性。`

## 启动流程

参考链接

[[SpringBoot源码分析之SpringBoot的启动过程](https://www.cnblogs.com/duanxz/p/9380569.html)](https://www.cnblogs.com/duanxz/p/9380569.html)

总结来说

* Spring Boot的启动过程，实际上就是对ApplicationContext的初始化过程。
* ApplicationContext创建后立刻为其设置Environment，并由ApplicationContextInitializer对其进一步封装。
* 通过SpringApplicationRunListener在ApplicationContext初始化过程中各个时点发布各种广播事件，并由ApplicationListener负责接收广播事件。
* 初始化过程中完成IoC的注入，包括通过@EnableAutoConfiguration导入各种自动配置类。
* 初始化完成前调用ApplicationRunner和CommandLineRunner的实现类。
