package com.baihy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.aop
 * @description:
 * @author: huayang.bai
 * @date: 2019/06/03 14:24
 */
@Aspect
public class AspectConfig {

    @Pointcut("execution(* com.baihy.service.*.*(..))")
    public void test() {
    }


    @Before("test()")
    public void testBefore() {
        System.out.println("方法拦截之前");
    }


    @After("test()")
    public void testAfter() {
        System.out.println("方法拦截之后");
    }

    @Around("test()")
    public Object testAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知，调用之前");
        Object[] args = joinPoint.getArgs();
        System.out.println("方法的参数列表：" + Arrays.toString(args));
        Object proceed = joinPoint.proceed(args);
        System.out.println("环绕通知，调用之后");
        System.out.println("方法的返回值：" + proceed);
        return proceed;
    }


}
