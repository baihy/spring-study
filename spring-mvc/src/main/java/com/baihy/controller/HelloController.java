package com.baihy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: spring
 * @packageName: com.baihy.controller
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-11 10:44
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println("我是原生的springmvc");
        return "success";
    }

}
