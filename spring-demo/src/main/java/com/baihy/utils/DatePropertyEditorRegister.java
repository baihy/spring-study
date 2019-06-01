package com.baihy.utils;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.utils
 * @description:
 * @author: huayang.bai
 * @date: 2019-06-01 09:04
 */

public class DatePropertyEditorRegister implements PropertyEditorRegistrar {


    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        // registry.registerCustomEditor(Date.class, new DatePropertyEditor());
        // 两种方式，可以自定义属性编辑器，也可以使用spring提供的，spring提供的需要传入DateFormat.第二个参数是：是否允许为null
        registry.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}
