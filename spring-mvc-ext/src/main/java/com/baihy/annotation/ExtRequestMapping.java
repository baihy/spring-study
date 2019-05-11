package com.baihy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @projectName: spring
 * @packageName: com.baihy.annotation
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-11 14:06
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExtRequestMapping {

    String value() default "";

}


