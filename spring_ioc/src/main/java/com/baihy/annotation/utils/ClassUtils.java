package com.baihy.annotation.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassUtils {

    public static List<Class<?>> getClassesByPackageName(String packageName) throws IOException, ClassNotFoundException {
        String packagePath = packageName.replace(".", File.separator);
        Enumeration<URL> iterator = Thread.currentThread().getContextClassLoader().getResources(packagePath);
        List<Class<?>> list = new ArrayList<>();
        URL url = null;
        File file = null;
        File[] fls = null;
        Class<?> clazz = null;
        String className = null;
        String classFullName = null;
        while (iterator.hasMoreElements()) {
            url = iterator.nextElement();
            if ("file".equals(url.getProtocol())) {
                file = new File(url.getPath());
                if (file.isDirectory()) {
                    fls = file.listFiles();
                    for (File fl : fls) {
                        className = fl.getName();
                        className = className.substring(0, className.lastIndexOf(".")); //获取该类的类名 person
                        classFullName = packageName + "." + className;//该类的完整名称,例如com.xx.person
                        clazz = Thread.currentThread().getContextClassLoader().loadClass(classFullName);
                        list.add(clazz);
                    }
                }
            }
        }
        return list;
    }


}
