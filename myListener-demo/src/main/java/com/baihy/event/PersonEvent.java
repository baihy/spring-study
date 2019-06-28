package com.baihy.event;

import com.baihy.source.Person;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.event
 * @description: 事件对象
 * @author: huayang.bai
 * @date: 2019/06/28 15:20
 */
public class PersonEvent {

    private Person person;


    public PersonEvent(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

