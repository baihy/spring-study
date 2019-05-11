package com.baihy.controller;

import com.baihy.annotation.ExtController;
import com.baihy.annotation.ExtRequestMapping;

/**
 * @projectName: spring
 * @packageName: com.baihy.controller
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-11 14:08
 */
@ExtController
@ExtRequestMapping("/ext")
public class HelloController {


    @ExtRequestMapping("/hello")
    public String sayHello() {
        System.out.println("*****手写的springmvc*****");
        return "success";
    }

}
