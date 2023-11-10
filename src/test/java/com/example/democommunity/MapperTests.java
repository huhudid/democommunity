package com.example.democommunity;

import com.example.democommunity.dao.DiscussPostMapper;
import com.example.democommunity.dao.UserMapper;
import com.example.democommunity.entity.DiscussPost;
import com.example.democommunity.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(
        classes = {DemocommunityApplication.class}
)
public class MapperTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;


    public MapperTests() {
    }

    @Test
    public void testSelectPosts() {
        List<DiscussPost> list= discussPostMapper.selectDiscussPosts(149,0,10);
        for(DiscussPost post :list)
        {
            System.out.println(post);
        }

        int rows=discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);

    }

}

