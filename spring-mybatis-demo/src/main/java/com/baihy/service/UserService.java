package com.baihy.service;

import com.baihy.domain.User;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.service
 * @description:
 * @author: huayang.bai
 * @date: 2019/06/04 9:13
 */
public interface UserService {

    int insert(User user);



    User get(Integer id);


}
