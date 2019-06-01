package com.baihy.event;

import org.springframework.context.ApplicationEvent;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.event
 * @description:
 * @author: huayang.bai
 * @date: 2019-06-01 10:50
 */
public class TestEvent extends ApplicationEvent {

    private String message;

    public TestEvent(Object source) {
        super(source);
    }

    public TestEvent(Object source, String message) {
        super(source);
        this.message = message;
    }


    public void print() {
        Object source = getSource();
        System.out.println(source.getClass());
        System.out.println(this.message);
    }
}
