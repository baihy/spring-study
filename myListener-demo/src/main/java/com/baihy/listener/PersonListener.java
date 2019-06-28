package com.baihy.listener;

import com.baihy.event.PersonEvent;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.listener
 * @description:  事件的监听器
 * @author: huayang.bai
 * @date: 2019/06/28 15:20
 */
public interface PersonListener {


    void doEat(PersonEvent event);

    void doRun(PersonEvent event);


}
