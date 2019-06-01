package com.baihy.beanfactory.test;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.beanfactory.test
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-25 19:49
 */
@Data
@Accessors(chain = true)
public class MyTestBean {

    private String testStr = "hello world";

    private Date birthday;

}
