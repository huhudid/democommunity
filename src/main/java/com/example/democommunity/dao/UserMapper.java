package com.example.democommunity.dao;


import com.example.democommunity.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper {
    User selectById(int id);
    User selectByName(int username);
    User selectByEmail(String email);
    int insertUser( User user);
    int updateStatus(int id,int status);
    int updateHeader(int id, String headerUrl);
    int updatePassword(int id,String password);
}
