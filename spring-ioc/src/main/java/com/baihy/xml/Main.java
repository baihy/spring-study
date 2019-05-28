package com.baihy.xml;

import com.baihy.xml.context.ClasspathXmlApplicationContext;
import com.baihy.xml.service.UserService;
import org.dom4j.DocumentException;


public class Main {


    public static void main(String[] args) {

        try {
            ClasspathXmlApplicationContext applicationContext = new ClasspathXmlApplicationContext("student.xml");
            UserService userService = (UserService) applicationContext.getBean("userService");
            userService.save();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
