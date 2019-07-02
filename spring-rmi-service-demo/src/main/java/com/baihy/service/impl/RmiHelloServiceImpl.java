package com.baihy.service.impl;

import com.baihy.service.RmiHelloService;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.service
 * @description:
 * @author: huayang.bai
 * @date: 2019/07/02 14:20
 */
public class RmiHelloServiceImpl implements RmiHelloService {
    @Override
    public void sayHello() {
        System.out.println("**************RmiHelloServiceImpl*****************");
    }
}
