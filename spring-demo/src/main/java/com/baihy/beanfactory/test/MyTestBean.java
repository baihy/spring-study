package com.baihy.beanfactory.test;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.beanfactory.test
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-25 19:49
 */
public class MyTestBean {

    private String testStr = "hello world";

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }
}
