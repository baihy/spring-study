package com.baihy.service;

import com.baihy.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.service
 * @description:
 * @author: huayang.bai
 * @date: 2019/06/04 9:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testInsert() {
        int result = userService.insert(new User().setUsername("user").setPassword("pwd"));
        System.out.println(result);
    }


    @Test
    public void testGet() {
        User user = userService.get(29);
        System.out.println(user);
    }


    @Test
    public void testFind() {
        List<User> users = userService.find(new User());
        System.out.println(users);
    }

    @Test
    public void testFindAll() {
        List<User> users = userService.find();
        System.out.println(users);
    }

}
