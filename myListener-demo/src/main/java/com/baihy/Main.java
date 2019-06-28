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

    public static void main(String[] args){
        Person person = new Person(new MyListener());
        person.eat();
    }

}
