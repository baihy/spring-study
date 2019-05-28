package com.baihy.parser;

import com.baihy.domain.UserDemo;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.parser
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-26 14:23
 */
public class UserDemoBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    // 返回标签对应的类的字节码对象
    @Override
    protected Class<?> getBeanClass(Element element) {
        return UserDemo.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String username = element.getAttribute("username");
        String password = element.getAttribute("password");
        // 把提取到的数据放入到BeanDefinitionBuilder中
        builder.addPropertyValue("username", username);
        builder.addPropertyValue("password", password);
    }
}
