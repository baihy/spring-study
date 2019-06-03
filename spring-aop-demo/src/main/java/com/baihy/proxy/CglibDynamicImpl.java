package com.baihy.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.proxy
 * @description:
 * @author: huayang.bai
 * @date: 2019/06/03 10:56
 */
public class CglibDynamicImpl {


    private Object target;

    public Object bind(Object target) {
        this.target = target;
        // 创建代理对象，这是代理对象继承真实的对象，所以通过cglib实现动态代理存在缺点：如果真实的对象是final修饰的类，就会报错，没办法继承
        Enhancer dynamic = new Enhancer();
        dynamic.setSuperclass(target.getClass());
        dynamic.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object obj = null;
                System.out.println("方法调用之前，参数是：" + Arrays.toString(objects));
                obj = method.invoke(target, objects);
                System.out.println("方法的返回值：" + obj);
                System.out.println("方法调用之后，参数是：" + Arrays.toString(objects));
                return obj;
            }
        });
        return dynamic.create();
    }

}
