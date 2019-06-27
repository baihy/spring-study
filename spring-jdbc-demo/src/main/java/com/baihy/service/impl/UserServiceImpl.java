package com.baihy.service.impl;

import com.baihy.domain.User;
import com.baihy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Types;
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
        return jdbcTemplate.update("insert t_user (username, password) values (?,?)", new Object[]{user.getUsername(), user.getPassword()}, new int[]{Types.VARCHAR, Types.VARCHAR});
    }

    @Override
    public List<User> find(User param) {
        String sql = "select * from t_user";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new User().setId(rs.getInt("id")).setUsername(rs.getString("username")).setPassword(rs.getString("password"))
        );
    }

    @Override
    public List<User> find() {
        String sql = "select * from t_user";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User get(Integer id) {
        String sql = "select * from t_user where id = ?";
        return jdbcTemplate.queryForObject(sql, User.class, id);
    }
}
