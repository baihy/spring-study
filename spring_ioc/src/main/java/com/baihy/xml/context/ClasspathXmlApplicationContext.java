package com.baihy.xml.context;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * @author huayang.bai
 */
public class ClasspathXmlApplicationContext {


    /**
     * 代码从哪些角度来重构：
     *  1.for循环，一定封装到只有一层，不能，有过的的for循环嵌套
     *  2.尽量去掉if-else代码块
     *  3.写代码之后，一定要想一下，怎么封装，怎么重构
     */


    private String xmlPath;

    public ClasspathXmlApplicationContext(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    /**
     * 根据bean的id属性获取bean的对象
     *
     * @param sourceBeanId
     * @return
     * @throws DocumentException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public Object getBean(String sourceBeanId) throws DocumentException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        /*******获取所有的bean标签信息。******/
        List<Element> elements = readXml();
        if (elements == null || elements.isEmpty()) {
            return null;
        }
        /************根据传入的beanId的名称获取到class属性值*****************/
        String beanName = findBeanNameById(elements, sourceBeanId);

        /******通过反射来实例化对象*********/
        return getInstance(beanName);
    }

    /**
     * 通过bean的id获取bean的全类名
     *
     * @param sourceBeanId
     * @return
     * @throws DocumentException
     */
    public String findBeanNameById(List<Element> elements, String sourceBeanId) throws DocumentException {
        for (Element element : elements) {
            /****API方法的含义是：获取指定属性的值*****/
            String beanId = element.attributeValue("id");
            if (sourceBeanId.equals(beanId)) {
                return element.attributeValue("class");
            }
        }
        return null;
    }


    /**
     * 通过反射实例化对象
     *
     * @param className
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private Object getInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName(className);
        return clazz.newInstance();
    }

    /**
     * 读取XML配置文件
     *
     * @return
     * @throws DocumentException
     */
    private List<Element> readXml() throws DocumentException {
        InputStream inputStream = getStream();
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        Element rootElement = document.getRootElement();
        return rootElement.elements();
    }

    /**
     * 获取当前上下文对象
     *
     * @return
     */
    private InputStream getStream() {
        return this.getClass().getClassLoader().getResourceAsStream(this.xmlPath);
    }


}
