package com.baihy.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.config
 * @description:
 * @author: huayang.bai
 * @date: 2019/07/18 15:50
 */
@Configurable
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("com.baihy")
public class AopConfig {
}
