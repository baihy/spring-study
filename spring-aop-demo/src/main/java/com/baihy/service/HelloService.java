package com.baihy.service;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.service
 * @description:
 * @author: huayang.bai
 * @date: 2019/06/03 14:23
 */
public class HelloService {

    public String sayHello(String name) {
        System.out.println("hello world");
        return "hello," + name;
    }

}
