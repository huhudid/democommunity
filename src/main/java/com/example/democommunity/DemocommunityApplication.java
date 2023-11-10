package com.example.democommunity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.example.democommunity.dao"})
public class DemocommunityApplication {

    public static void main(String[] args)
    {
        //自动创建Spring容器，自动扫描有Component修饰的类的bean对象
        SpringApplication.run(DemocommunityApplication.class, args);
    }

}
