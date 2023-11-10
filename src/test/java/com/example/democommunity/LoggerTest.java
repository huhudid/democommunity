package com.example.democommunity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

//记录日志输出到控制台,按照不同的log级别存到不同的文件中
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = DemocommunityApplication.class)
public class LoggerTest {
    private static final Logger logger= LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void testLogger(){
        System.out.println(logger.getName());//输出logger的名字
        logger.debug("debug log");//调试程序
        logger.info("info log");//普通级别日志,正常记录
        logger.warn("warn log");//警告级别日志
        logger.error("error log");//错误级别日志
        //在配置文件中配置logger的级别
    }
}
