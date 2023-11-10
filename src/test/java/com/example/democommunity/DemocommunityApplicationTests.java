package com.example.democommunity;

import com.example.democommunity.dao.AlphaDao;
import com.example.democommunity.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = DemocommunityApplication.class)
class DemocommunityApplicationTests implements ApplicationContextAware {

    //容器
    private ApplicationContext applicationContext;

    //传进spring容器
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //获取spring容器
        this.applicationContext = applicationContext;
    }

    @Test
    public void testApplicationContext() {

        System.out.println(applicationContext);
        //通过bean的名字获取bean对象
        AlphaDao alphaDao=applicationContext.getBean("alphaDaoMybaits",AlphaDao.class);
        System.out.println(alphaDao.select());
        //org.springframework.web.context.support...
    }

    @Test
    public void testBeanManagement(){
        //被Spring容器管理的bean默认是单例的，只实例化一次
        AlphaService alphaService=applicationContext.getBean(AlphaService.class);
        System.out.println(alphaService);
    }

    @Test
    public void testBeanConfig(){
        SimpleDateFormat simpleDateFormat=applicationContext.getBean(SimpleDateFormat.class);
        System.out.println(simpleDateFormat.format(new Date()));
    }

    //Spring容器把AlphaDao注入给属性alphaDao
    @Autowired
    @Qualifier("alphaDaoHiberbatel")
    //声明属性，依赖接口
    private AlphaDao alphaDao;

    @Test
    public void testDI(){
        System.out.println(alphaDao);
    }

}
