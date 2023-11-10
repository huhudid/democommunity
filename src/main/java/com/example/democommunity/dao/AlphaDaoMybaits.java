package com.example.democommunity.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

//通过("")自定义bean的名字
@Repository("alphaDaoMybaits")
@Primary
//根据类型选择bean对象时，优先装配，可以替换原来的bean对象
public class AlphaDaoMybaits implements AlphaDao{
    @Override
    public String select() {
        return "Mybaits";
    }
}
