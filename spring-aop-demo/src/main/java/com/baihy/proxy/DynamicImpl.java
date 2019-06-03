package com.baihy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.proxy
 * @description:
 * @author: huayang.bai
 * @date: 2019/06/03 9:33
 */
public class DynamicImpl implements InvocationHandler {

    private Object developer;

    /**
     * 给真实的对象绑定代理对象
     *
     * @param developer
     * @return
     */
    public Object bind(Object developer) {
        this.developer = developer;
        // 代理代理对象的实现类的类加载器
        ClassLoader classLoader = this.getClass().getClassLoader();
        // 真实对象实现的接口数组，因为真实对象有可能实现多个接口
        Class<?>[] interfaces = developer.getClass().getInterfaces();
        // 实现了InvocationHandler接口的对象
        InvocationHandler invocationHandler = this;
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法调用之前，参数是：" + Arrays.toString(args));
        Object obj = method.invoke(developer, args);
        System.out.println("方法调用的返回值是：" + obj);
        System.out.println("方法调用之后，参数是：" + Arrays.toString(args));
        return obj;
    }
}
