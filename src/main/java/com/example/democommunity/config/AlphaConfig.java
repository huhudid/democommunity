package com.example.democommunity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

//表明为配置类
@Configuration
public class AlphaConfig {

    //该方法返回的bean对象将被装配到容器中，bean的名字为方法名
    @Bean
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
