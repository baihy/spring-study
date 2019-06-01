package com.baihy.test;

import com.baihy.beanfactory.test.MyTestBean;
import com.baihy.context.MyClassPathXmlApplication;
import com.baihy.domain.UserDemo;
import com.baihy.event.TestEvent;
import com.baihy.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
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


    /***
     * 测试自定义标签
     */
    @Test
    public void testApplicationContext() {
        ApplicationContext context = new MyClassPathXmlApplication("applicationContext.xml");
        UserDemo userDemo = context.getBean(UserDemo.class);
        System.out.println(userDemo.getUsername() + "*******" + userDemo.getPassword());
    }


    /***
     * 测试自定义标签
     */
    @Test
    public void testProperty() {
        ApplicationContext context = new MyClassPathXmlApplication("applicationContext.xml");
        MyTestBean testBean = context.getBean(MyTestBean.class);
        System.out.println(testBean);
    }

    /***
     *  测试自定义事件
     */
    @Test
    public void testEvent() {
        ApplicationContext context = new MyClassPathXmlApplication("applicationContext.xml");
        TestEvent testEvent = new TestEvent(this, "baihuayang");
        context.publishEvent(testEvent);
    }

    /***
     * 测试切面编程
     */
    @Test
    public void testAop() {
        ApplicationContext context = new MyClassPathXmlApplication("applicationContext.xml");
        UserService userService = context.getBean(UserService.class);
        userService.test("baihuayang");
    }


}
