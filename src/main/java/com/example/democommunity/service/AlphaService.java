package com.example.democommunity.service;

import com.example.democommunity.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//每次访问bean创建一个对象，实例化多次，默认单例：singnal
//@Scope("prototype")
public class AlphaService {
    @Autowired
    private AlphaDao alphaDao;

    //通过bean容器能否自动的调用初始化和销毁方法
    public AlphaService(){
        System.out.println("实例化AlphaService");
    }

    @PostConstruct
    public void init(){
        System.out.println("初始化AlphaService");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁AlphaService");
    }

    public String find(){
        return alphaDao.select();
    }
}
