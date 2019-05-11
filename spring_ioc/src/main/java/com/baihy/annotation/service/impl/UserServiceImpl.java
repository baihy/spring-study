package com.baihy.annotation.service.impl;

import com.baihy.annotation.annotation.ExtResource;
import com.baihy.annotation.annotation.ExtService;
import com.baihy.annotation.service.OraderService;
import com.baihy.annotation.service.UserService;


@ExtService
public class UserServiceImpl implements UserService {

    @ExtResource
    private OraderService oradleServiceImpl;


    @Override
    public void save() {
        System.out.println("********通过反射生成实例化对象***********");
        oradleServiceImpl.save();
    }
}
