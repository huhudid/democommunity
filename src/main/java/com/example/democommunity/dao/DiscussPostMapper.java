package com.example.democommunity.dao;

import com.example.democommunity.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    //分解查询多条帖子，返回集合对象
    List<DiscussPost> selectDiscussPosts(int userId,int offset,int limit);
    //@Param注解用于给参数取别名
    // 如果只有一个参数，并且在<if>中使用（动态SQL），则必须取别名
    int selectDiscussPostRows(@Param("userId") int userId);
}
