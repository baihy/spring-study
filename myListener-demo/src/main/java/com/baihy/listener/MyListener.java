package com.baihy.listener;

import com.baihy.event.PersonEvent;
import com.baihy.source.Person;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.listener
 * @description: 事件的监听器实现
 * @author: huayang.bai
 * @date: 2019/06/28 15:32
 */
public class MyListener implements PersonListener {
    @Override
    public void doEat(PersonEvent event) {
        Person person = event.getPerson();
        System.out.println(person + "**************eat**************");
    }

    @Override
    public void doRun(PersonEvent event) {
        Person person = event.getPerson();
        System.out.println(person + "**************run**************");
    }
}
