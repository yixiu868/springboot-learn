package com.ww.springbootlearn.json.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.text.SimpleDateFormat;

/**
 * 全局配置ObjectMapper使用日期格式
 * @author wanggw
 * @date 2022-01-20 00:20:41
 */
@Configuration
public class JsonDateConfig {
//    @Bean
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
