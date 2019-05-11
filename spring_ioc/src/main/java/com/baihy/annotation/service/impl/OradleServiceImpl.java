package com.baihy.annotation.service.impl;

import com.baihy.annotation.annotation.ExtService;
import com.baihy.annotation.service.OraderService;


@ExtService
public class OradleServiceImpl implements OraderService {

    @Override
    public void save() {
        System.out.println("******OradleServiceImpl*******");
    }
    
}
