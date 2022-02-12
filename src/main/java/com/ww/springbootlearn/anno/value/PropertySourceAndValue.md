# @PropertySource

**_通过@PropertySource可以指定读取的配置文件_**，通过@Value注解获取值。

`@PropertySource是Spring的注解，加载指定的属性文件的配置到Spring的Environment中，可以配合@Value和@ConfigurationProperties使用`

## 用法

* 1、@Configuration + @PropertySource + Environment

  ```java
  @Configuration
  @PropertySource("classpath:helloworld.properties")
  public class HelloWorldConfig {
      
      // helloworld.properties加载到Environment
      @Autowired
      private Environment env;
  }
  ```

  实现例子，`com.ww.springbootlearn.anno.value.User3Config`

* 2、@Configuration + @PropertySource + @Value

  ```java
  @Configuration
  @PropertySource("classpath:helloworld.properties")
  public class HelloWorldConfig {
      
      @Value(${my.name})
      private String name;
  }
  ```

  实现例子，`com.ww.springbootlearn.anno.value.User`

* 3、@Configuration + @PropertySource + @ConfigurationProperties

  @PropertySource指定加载哪个文件，@ConfigurationProperties指定加载文件中的哪一类属性。@PropertySource + @ConfigurationProperties在一起解决了@ConfigurationProperties只加载主文件内属性问题。

  ```java
  @Configuration
  @PropertySource("classpath:helloworld.properties")
  @ConfigurationProperties(prefix = "my")
  public class HelloWorldConfig {
      
      private String name;
  }
  ```

  实现例子，`com.ww.springbootlearn.anno.configproperties.User3`

参考链接

[Spring高级之注解@PropertySource详解](https://blog.csdn.net/qq_40837310/article/details/106587158)

`Spring4.3之前，除了使用@PropertySource注解之外，还要手动注册一个资源文件解析器PropertySourcesPlaceholderConfigurer到IoC容器中。之后，就可以直接使用，因为Spring会使用默认的DefaultPropertySourceFactory解析。`
