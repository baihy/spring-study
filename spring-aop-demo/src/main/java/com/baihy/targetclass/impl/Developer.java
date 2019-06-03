package com.baihy.targetclass.impl;

import com.baihy.targetclass.IDeveloper;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.targetclass.impl
 * @description:
 * @author: huayang.bai
 * @date: 2019/06/03 9:32
 */
public final class Developer implements IDeveloper {

    @Override
    public void develop(String name) {
        System.out.println("hello, " + name);
    }
}
