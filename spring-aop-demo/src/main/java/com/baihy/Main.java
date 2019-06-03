package com.baihy;

import com.baihy.proxy.CglibDynamicImpl;
import com.baihy.proxy.DynamicImpl;
import com.baihy.service.HelloService;
import com.baihy.targetclass.IDeveloper;
import com.baihy.targetclass.impl.Developer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @projectName: spring-study
 * @packageName: com.baihy
 * @description:
 * @author: huayang.bai
 * @date: 2019/06/03 9:45
 */
public class Main {

    public static void main(String[] args) {
        testAop();
    }

    /**
     * 测试aop
     */
    public static void testAop() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloService helloService = context.getBean(HelloService.class);
        String result = helloService.sayHello("柏华洋");
        System.out.println(result);
    }

    /**
     * 通过jdk实现了动态代理
     */
    public static void jdk() {
        IDeveloper target = new Developer();
        IDeveloper proxy = (IDeveloper) new DynamicImpl().bind(target);
        proxy.develop("baihuayang");
    }

    /**
     * 通过cglib实现了动态代理
     */
    public static void cglib() {
        IDeveloper target = new Developer();
        IDeveloper proxy = (IDeveloper) new CglibDynamicImpl().bind(target);
        proxy.develop("baihuayang");
    }


}

