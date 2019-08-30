package com.baihy.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.config
 * @description:
 * @author: huayang.bai
 * @date: 2019/8/30 9:15 下午
 */
@Configurable
public class MybatisConfig {


    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        // 因为SQLSessionFactoryBean实现了FactoryBean接口，交个spring容器
        // 有两个对象。一个是：SqlSessionFactoryBean对象，一个是getObject方法的返回值类型的对象
        return new SqlSessionFactoryBean();
    }

}
