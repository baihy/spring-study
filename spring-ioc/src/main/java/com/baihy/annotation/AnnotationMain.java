package com.baihy.annotation;

import com.baihy.annotation.context.ExtClasspathAnnotationApplicationContext;
import com.baihy.annotation.service.UserService;


public class AnnotationMain {

    /**
     * 实现思路：
     * 1.扫描指定的包
     * 2.通过反射获取包下面所有的类头上有指定注册的类信息。
     * 3.通过beanId值，获得指定类的信息
     * 4.通过反射，根据类信息，实例化对象
     * 5.返回实例化完成的对象
     */


    public static void main(String[] args) throws Exception {

        String packageName = "com.baihy.annotation.service.impl";
        ExtClasspathAnnotationApplicationContext context = new ExtClasspathAnnotationApplicationContext(packageName);
        UserService userService = (UserService) context.getBean("userServiceImpl");
        userService.save();
        
    }

}
