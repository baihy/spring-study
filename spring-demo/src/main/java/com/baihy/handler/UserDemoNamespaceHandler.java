package com.baihy.handler;

import com.baihy.parser.UserDemoBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @projectName: spring-study
 * @packageName: com.baihy
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-26 14:28
 */
public class UserDemoNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        // 注册beanDefinition的解析器 注意，这里的标签名称必须要和xsd文件中指定的标签名称一致
        registerBeanDefinitionParser("user", new UserDemoBeanDefinitionParser());
    }
}
