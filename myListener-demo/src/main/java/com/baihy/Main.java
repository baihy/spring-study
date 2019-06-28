package com.baihy;

import com.baihy.listener.MyListener;
import com.baihy.source.Person;

/**
 * @projectName: spring-study
 * @packageName: com.baihy
 * @description:
 * @author: huayang.bai
 * @date: 2019/06/28 15:28
 */
public class Main {

    public static void main(String[] args) {
        Person person = new Person(new MyListener()); // 给事件源上加一个监听
        person.eat();

        Person person1 = new Person(); // 事件源不加监听
        person1.eat();
    }

}
