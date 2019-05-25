package com.baihy.test;

import com.baihy.beanfactory.test.MyTestBean;
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

    @Test
    public void testBeanFactory() {
        ClassPathResource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        MyTestBean myTestBean = (MyTestBean) beanFactory.getBean("test");
        System.out.println(myTestBean.getTestStr());
    }


}
