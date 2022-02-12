# SpringBoot配置JSON日期格式serialize、deserialize
> 参考资料
* [Formatting JSON Dates in SpringBoot](https://www.baeldung.com/spring-boot-formatting-json-dates)
* [Spring Jackson custom date format](https://javadeveloperzone.com/spring/spring-jackson-custom-date-format/)
* [Rest Controller — Configure Date & Time Format in JSON Response](https://medium.com/@andylke/rest-controller-configure-date-time-format-in-json-response-201e97aa74b0)
* [Spring Boot – Customize the Jackson ObjectMapper](https://www.geeksforgeeks.org/spring-boot-customize-the-jackson-objectmapper/)
* [Jackson序列化（1）— [SpringBoot2.x]-Jackson在HttpMessageConverter（消息转换器）中的使用](https://www.jianshu.com/p/560e9b114c29)

## 方法1 @JsonFormat

使用@JsonFormat设置在Date类型字段上

```java
public class Contact {
    
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthday;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Europe/Zagreb")
    private LocalDateTime lastUpdate;
}
```

```java
public class ContactWithJavaUtilDate {
    
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthday;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastUpdate;
}
```

缺点：每个Date类型上都需要进行设置；

> 输出
>
> ```json
> {
>     "birthday": "2022-02-09",
>     "lastUpdate": "2022-02-09 23:34:26"
> }
> ```

## 方法2 优化@JsonFormat硬编码

在application.properties中配置如下，针对所有@JsonFormat有效

```properties
spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
spring.jackson.time-zone=Europe/Zagreb
```

it doesn't work with the Java 8 date types, like LocalDate and LocalDateTime，we can use it only to format fields of the type java.util.Date or the java.util.Calendar.

## 方法3 自定义ObjectMapper

```java
@Configuration
public class ContactAppConfig {
    
    private static final String dateFormat = "yyyy-MM-dd";
    private static final String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";
    
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> {
        	builder.simpleDateFormat(dateFormat);
          	builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(dateFormat)));
            builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)));
        };
    }
}
```

## 方法4 自定义JSON Serialize and Deserialize

[Spring boot custom JSON Serialize - Deserialize Example]([Spring boot custom JSON Serialize - Deserialize Example - Java Developer Zone](https://javadeveloperzone.com/spring-boot/spring-boot-custom-json-serialize-deserialize-example/))

借助@JsonComponent注解我们可以自定义JSON request or response.

举例说明java.time.Instant类型实例是不能直接转为JSON格式，默认look like

```json
{
    "no": 1,
    "name": "Bob",
    "designation": "Developer",
    "gender": "Male",
    "instant": {
        "epochSecond": 1532150600,
        "nano": 737000000
    }
}
```

> Spring boot使用Jackson，不需要额外的依赖，因为Jackson is part of spring boot.

@JsonComponent注解作为bean或module注入到spring boot context，可以被用于serialize and deserialize。

定义两个static class分别extends `JsonSerializer and JsonDeserializer`用于序列化与反序列化。

```java
@JsonComponent
public class DateConverter {
    
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat(DATE_FORMAT);
    
    public static class Serialize extends JsonSerializer<Instant> {
        
        public void serialize(Instant value, JsonGenerator jgen, SerializerProvider provider) {
            try {
                if (null == value) {
                    jgen.writeNull();
                } else {
                    jgen.writeString(DateTimeFormatter.ofPattern(DATE_FORMAT).withZone(ZoneId.systemDefault)).format(value));
                } 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static class Deserialize extends JsonDeserializer<Instant> {
        
        public Instant deserialize(com.fasterxml.jackson.core.JsonParser jp, DeserializationContext ctxt) throws IOException {
            try {
                String dateAsString = jp.getText();
                if (null == dateAsString) {
                    return null;
                } else {
                    return Instant.ofEpochMilli(sdf1.parse(dateAsString).getTime());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            return null;
        }
    }
}
```

## 方法5 利用HttpMessageConverter

[ SpringBoot2.x-Jackson在HttpMessageConverter（消息转换器）中的使用](https://www.jianshu.com/p/560e9b114c29)

SpringMVC的Http序列化和反序列化的核心是HttpMessageConverter，在SSM项目中，我们需要在xml配置文件中注入`MappingJackson2HttpMessageConverter`，告诉SpringMVC我们需要JSON格式的转换。

在请求时SpringMVC会在请求头中寻找contentType参数，然后去匹配能够处理这种类型的消息转换器。在返回数据时，SpringMVC根据请求头的Accept属性，再将对象转换成响应报文。

SpringBoot中会将MappingJackson2HttpMessageConverter自动装载到IoC容器中。

```java
@Configuration
public class JsonDateConfig {
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(
            @Autowired
                    ObjectMapper objectMapper) {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter =
                new MappingJackson2HttpMessageConverter();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
        return mappingJackson2HttpMessageConverter;
    }
}
```

