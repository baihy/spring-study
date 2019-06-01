package com.baihy.utils;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.utils
 * @description:
 * @author: huayang.bai
 * @date: 2019-06-01 09:04
 */

public class DatePropertyEditor extends PropertyEditorSupport {


    private String format = "yyyy-MM-dd";

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println(text);
        try {
            Date date = new SimpleDateFormat(format).parse(text);
            this.setValue(date);
        } catch (ParseException e) {
            System.out.println("日期类型转换失败！！！！！");
        }
    }
}
