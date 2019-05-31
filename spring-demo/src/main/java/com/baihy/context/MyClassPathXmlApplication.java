package com.baihy.context;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.context
 * @description:
 * @author: huayang.bai
 * @date: 2019/05/29 18:04
 */
public class MyClassPathXmlApplication extends ClassPathXmlApplicationContext {


    public MyClassPathXmlApplication(String resource) {
        super(resource);
    }


    @Override
    protected void initPropertySources() {
        // 表示的含义是：验证操作系统是否有指定的环境变量
        this.getEnvironment().setRequiredProperties("JAVA_HOME");
    }
}
