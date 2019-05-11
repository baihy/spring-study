package com.baihy.servlet;

import com.baihy.annotation.ExtController;
import com.baihy.annotation.ExtRequestMapping;
import com.baihy.utils.ClassUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @projectName: spring
 * @packageName: com.baihy.servlet
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-11 14:09
 */
public class DispatcherServlet extends HttpServlet {
    /**
     * 1.创建一个前端控制器（ExtDispatcherServlet）拦截所有的请求，springmvc是基于Servlet实现的。
     * 2.初始化操作（重写Servlet的init方法）
     * 2.1将扫描范围内的所有类，注入到spring容器中，存放格式是Map，key是类的简单类名，value是类的对象
     * 2.2获取到容器所有的类，循环拿到标有特殊注解的类，且拿到类中的方法。目的是初始化完成请求地址和处理请求请发之间的对应关系。
     * 所以，我们可以初始化两个，请求地址为key，spring容器中的对象为value；另一个是请求地址为key，处理请求的方法为value
     * 2.3方法的反射调用是通过：类对象+方法
     * 3.当请求时，获取请求地址，通过请求地址获取相应的处理请求方法
     * 根据请求地址获取对象和处理请求的方法，之后通过反射机制调用执行。
     * 4.处理请求处理的结果
     */

    private final String basePackage = "com.baihy.controller";
    /*map的键值对的值为什么是Object，因为如果是字节码类型的话，在获取bean的时候，获取到的是多实例对象*/
    private final ConcurrentHashMap<String, Object> springIoc = new ConcurrentHashMap<>();
    /***
     * 线面两个集合的作用是：通过请求地址，获取相关的请求处理器
     * 键值对的类型是是根据取的时候确定的。
     */
    private final ConcurrentHashMap<String, Method> handlerMapping = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> springmvcBeans = new ConcurrentHashMap<>();


    @Override
    public void init() throws ServletException {
        /**
         * 1.扫描指定的包下的所有类。
         * 2.过滤出类头上有指定注解的类，并完成初始化
         */
        List<Class<?>> classListWithAnnotation = getCLassInfoWith(ClassUtils.getClasses(basePackage));
        initSpringIoc(classListWithAnnotation);
        initHandlerMapping();
    }

    /**
     * 获取加了指定注解的类
     *
     * @param classList
     * @return
     */
    public List<Class<?>> getCLassInfoWith(List<Class<?>> classList) {
        if (classList != null && !classList.isEmpty()) {
            return classList.stream().filter(classInfo -> classInfo.getAnnotation(ExtController.class) != null).collect(Collectors.toList());
        }
        return null;
    }

    /**
     * 把添加了Controller注解类放入ioc容器中。
     *
     * @param classList
     */
    public void initSpringIoc(List<Class<?>> classList) {
        if (classList != null && !classList.isEmpty()) {
            classList.forEach(classInfo -> {
                try {
                    springIoc.put(ClassUtils.toLowerCaseFirstOne(classInfo.getSimpleName()), ClassUtils.newInstance(classInfo));
                } catch (ReflectiveOperationException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     * 初始化handlermapping
     */
    public void initHandlerMapping() {
        if (springIoc != null && !springIoc.isEmpty()) {
            Set<Map.Entry<String, Object>> entrySet = springIoc.entrySet();
            entrySet.forEach(entry -> {
                // 从容器中获取对象
                Object obj = entry.getValue();
                // 判断类上有没有ExtRequestMapping注解
                Class<?> classInfo = obj.getClass();
                ExtRequestMapping parent = classInfo.getAnnotation(ExtRequestMapping.class);
                Method[] methods = classInfo.getMethods();
                if (methods != null && methods.length > 0) {
                    for (int i = 0; i < methods.length; i++) {
                        Method method = methods[i];
                        // 判断方法上有没有ExtRequestMapping注解
                        ExtRequestMapping methodAnnotation = method.getAnnotation(ExtRequestMapping.class);
                        if (methodAnnotation != null) {
                            String path = getRequestPath(parent, methodAnnotation);
                            handlerMapping.put(path, method);
                            springmvcBeans.put(path, obj);
                        }
                    }
                }
            });
        }
    }


    public String getRequestPath(ExtRequestMapping parent, ExtRequestMapping method) {
        StringBuilder path = new StringBuilder();
        if (parent != null) {
            path.append(parent.value());
        }
        if (method != null) {
            path.append(method.value());
        }
        return path.toString();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result = null;
        //1.通过request对象获取url
        String path = request.getServletPath();
        //2.通过url地址，获取Controller对象
        Object obj = this.springmvcBeans.get(path);
        //3.通过url地址，获取请求处理器，
        if (obj != null) {
            Method method = this.handlerMapping.get(path);
            //4.通过反射机制来，调用方法。
            Object resultObj = invokeMethod(obj, method);
            if (resultObj != null) {
                result = resultObj.toString();
            }
        } else {
            // 如果没有，说明不存在，指定的请求地址。
            result = "404";
        }
        //5.把方法处理的结果返回
        handleResult(result, response);
    }

    private Object invokeMethod(Object object, Method method) {
        try {
            return method.invoke(object);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 处理返回结果
     *
     * @param result
     * @param response
     */
    public void handleResult(String result, HttpServletResponse response) throws IOException {
        OutputStream os = response.getOutputStream();
        os.write(result.getBytes());
        os.flush();
    }

}
