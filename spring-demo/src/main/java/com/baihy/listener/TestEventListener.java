package com.baihy.listener;

import com.baihy.event.TestEvent;
import org.springframework.context.ApplicationListener;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.listener
 * @description:
 * @author: huayang.bai
 * @date: 2019-06-01 10:52
 */
public class TestEventListener implements ApplicationListener<TestEvent> {
    @Override
    public void onApplicationEvent(TestEvent event) {
        event.print();
    }
}
