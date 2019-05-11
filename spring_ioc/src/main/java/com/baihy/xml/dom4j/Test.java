package com.baihy.xml.dom4j;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

public class Test {


    public static void main(String[] args) {
        try {
            new Test().readXml();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    public void readXml() throws DocumentException {
        SAXReader reader = new SAXReader();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("student.xml");
        Document document = reader.read(inputStream);
        Element rootElement = document.getRootElement();
        parseElement(rootElement);
    }

    /**
     * 递归调用节点展示节点的属性和属性值
     *
     * @param element
     */
    public void parseElement(Element element) {
        String name = element.getName();
        String text = element.getTextTrim();
        System.out.println("节点名称：" + name + "------" + "节点值是：" + text);
        System.out.println("*********************************************");
        List<Attribute> attributes = element.attributes();
        attributes.forEach(attribute -> {
            String attributeName = attribute.getName();
            String attributeText = attribute.getText();
            System.out.println("属性名是：" + attributeName + "-------" + "属性值是：" + attributeText);
        });
        System.out.println("*********************************************");


        Iterator<Element> it = element.elementIterator();
        while (it.hasNext()) {
            parseElement(it.next());
        }

    }


}
