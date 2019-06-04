package com.baihy.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.domain
 * @description:
 * @author: huayang.bai
 * @date: 2019/06/04 9:12
 */
@Data
@Accessors(chain = true)
public class User {

    private String username;

    private String password;

}
