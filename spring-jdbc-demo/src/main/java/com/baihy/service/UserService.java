package com.baihy.service;

import com.baihy.domain.User;

import java.util.List;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.service
 * @description:
 * @author: huayang.bai
 * @date: 2019/06/04 9:13
 */
public interface UserService {

    int insert(User user);


    List<User> find(User param);


    User get(Integer id);


}
