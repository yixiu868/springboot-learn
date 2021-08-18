# @PropertySource

通过@PropertySource可以指定读取的配置文件，通过@Value注解获取值。

`@PropertySource注解主要是让Spring的Environment接口读取属性配置文件用的，标识在@Configuration配置类上`

参考链接

[Spring高级之注解@PropertySource详解](https://blog.csdn.net/qq_40837310/article/details/106587158)

`Spring4.3之前，除了使用@PropertySource注解之外，还要手动注册一个资源文件解析器PropertySourcesPlaceholderConfigurer到IoC容器中。之后，就可以直接使用，因为Spring会使用默认的DefaultPropertySourceFactory解析。`
