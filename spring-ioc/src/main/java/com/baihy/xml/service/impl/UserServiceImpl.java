package com.baihy.xml.service.impl;

import com.baihy.xml.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("********通过反射生成实例化对象***********");
    }
}
