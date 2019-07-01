package com.baihy.servet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @projectName: spring-study
 * @packageName: com.baihy.servet
 * @description:
 * @author: huayang.bai
 * @date: 2019/07/01 11:07
 */
@WebServlet("/user.do")
public class UserServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        Enumeration<String> attributeNames = context.getInitParameterNames();
        while (attributeNames.hasMoreElements()){
            String s = attributeNames.nextElement();
            String abc = context.getInitParameter(s);
            System.out.println(abc);
        }
    }
}
