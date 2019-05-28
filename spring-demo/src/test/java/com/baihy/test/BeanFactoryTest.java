package com.baihy.test;

import com.baihy.beanfactory.test.MyTestBean;
import com.baihy.domain.UserDemo;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.test
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-25 19:52
 */
public class BeanFactoryTest {

    /**
     * 测试 XMlBeanFactory对象
     */
    @Test
    public void testBeanFactory() {
        ClassPathResource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        MyTestBean myTestBean = (MyTestBean) beanFactory.getBean("test");
        System.out.println(myTestBean.getTestStr());
    }


    /***
     * 测试自定义标签
     */
    @Test
    public void testTag() {
        ClassPathResource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        UserDemo userDemo = beanFactory.getBean(UserDemo.class);
        System.out.println(userDemo.getUsername() + "*******" + userDemo.getPassword());
    }


}
