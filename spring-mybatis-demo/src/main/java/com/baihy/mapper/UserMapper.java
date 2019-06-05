package com.baihy.mapper;

import com.baihy.domain.User;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.mapper
 * @description:
 * @author: huayang.bai
 * @date: 2019/06/05 17:38
 */
public interface UserMapper {

    int insert(User user);

    User get(Integer id);

}
