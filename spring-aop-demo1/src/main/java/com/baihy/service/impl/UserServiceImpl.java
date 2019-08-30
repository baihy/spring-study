package com.baihy.service.impl;

import com.baihy.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.service
 * @description:
 * @author: huayang.bai
 * @date: 2019/07/18 15:52
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void query() {
        System.out.println("查询操作");
    }
}
