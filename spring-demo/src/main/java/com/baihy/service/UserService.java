package com.baihy.service;

import org.springframework.stereotype.Service;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.service
 * @description:
 * @author: huayang.bai
 * @date: 2019-06-01 15:32
 */
@Service
public class UserService {


    public String test(String name) {
        System.out.println("***********test*************");
        return "hello world:" + name;
    }


}
