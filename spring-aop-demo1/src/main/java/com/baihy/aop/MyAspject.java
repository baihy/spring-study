package com.baihy.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.aop
 * @description:
 * @author: huayang.bai
 * @date: 2019/07/18 15:53
 */
@Component
@Aspect  // 声明这个类为切面
public class MyAspject {

    // 声明一个切点
    @Pointcut("execution(* com.baihy.service.*.*(..))")
    private void pointcut() {

    }

    // 声明一个通知
    @Before("pointcut()")
    public void myAdvice() {
        System.out.println("查询之前的操作");
    }

}
