package com.baihy;

import com.baihy.proxy.DynamicImpl;
import com.baihy.target.IDeveloper;
import com.baihy.target.impl.Developer;

/**
 * @projectName: spring-study
 * @packageName: com.baihy
 * @description:
 * @author: huayang.bai
 * @date: 2019/06/03 9:45
 */
public class Main {

    public static void main(String[] args) {
        IDeveloper target = new Developer();
        IDeveloper proxy = (IDeveloper) new DynamicImpl().bind(target);
        proxy.develop("baihuayang");
    }

}
