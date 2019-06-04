package com.baihy.service.impl;

import com.baihy.domain.User;
import com.baihy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.service.impl
 * @description:
 * @author: huayang.bai
 * @date: 2019/06/04 9:14
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(User user) {
        return jdbcTemplate.update("insert t_user (username, password) values (?,?)", user.getUsername(), user.getPassword());
    }

    @Override
    public List<User> find(User param) {
        return null;
    }
}
