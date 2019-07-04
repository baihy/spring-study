package com.baihy.source;

import com.baihy.event.PersonEvent;
import com.baihy.listener.PersonListener;
import lombok.extern.slf4j.Slf4j;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.source
 * @description: 事件源
 * @author: huayang.bai
 * @date: 2019/06/28 15:19
 */
@Slf4j
public class Person {

    private PersonListener personListener;


    public Person() {
    }

    public Person(PersonListener personListener) {
        this.personListener = personListener;
    }

    public void run() {
        if (personListener != null) {
            PersonEvent event = new PersonEvent(this);
            personListener.doEat(event);
        }
        System.out.println("*************run************");
    }


    public void eat() {
        if (this.personListener != null) {
            PersonEvent event = new PersonEvent(this);
            personListener.doEat(event);
        }
        System.out.println("*************eat************");
    }

}
