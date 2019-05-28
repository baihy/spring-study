package com.baihy.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.domain
 * @description: 实现自定标签扩展的实体类
 * @author: huayang.bai
 * @date: 2019-05-26 14:13
 */
@Data
@Accessors(chain = true)
public class UserDemo {

    private String username;

    private String password;

}
