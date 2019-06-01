package com.baihy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;


/**
 * @projectName: spring-study
 * @packageName: com.baihy.aop
 * @description:
 * @author: huayang.bai
 * @date: 2019-06-01 15:31
 */
@Aspect  // 通过过注解来指定当前类是切面类
public class AspectTest {

    /**
     * 定义切面
     */
    @Pointcut("execution(* com.baihy.service.*.*(..))")
    public void test() {

    }

    /**
     * 定义前置通知
     */
    @Before("test()")
    public void beforeTest() {
        System.out.println("*********切面的前置通知***********");
    }

    /**
     * 定义后置通知
     */
    @After("test()")
    public void aftreTest() {
        System.out.println("***********切面的后置通知*************");
    }

    /**
     * 切面的环绕通知
     *
     * @param joinPoint
     */
    @Around("test()")
    public void aroudTest(ProceedingJoinPoint joinPoint) {
        System.out.println("********方法调用之前*********");
        Object result = null;
        Object[] args = joinPoint.getArgs(); // 获取方法的实参列表
        System.out.println(Arrays.toString(args));
        try {
            result = joinPoint.proceed(args); // 调用参数传递的切面方法
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("方法的返回值：" + result);
        System.out.println("********方法调用之后*********");

    }

}
