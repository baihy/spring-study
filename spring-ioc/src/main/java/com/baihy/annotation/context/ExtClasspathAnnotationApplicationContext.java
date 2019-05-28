package com.baihy.annotation.context;


import com.baihy.annotation.annotation.ExtResource;
import com.baihy.annotation.annotation.ExtService;
import com.baihy.annotation.utils.ClassUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * @author huayang.bai
 */
public class ExtClasspathAnnotationApplicationContext {

    private String packageName;

    private ConcurrentMap<String, Object> beans;

    /**
     * 实现思路：
     * 1.扫描指定的包
     * 2.通过反射获取包下面所有的类头上有指定注册的类信息。
     * 3.通过beanId值，获得指定类的信息
     * 4.通过反射，根据类信息，实例化对象
     * 5.返回实例化完成的对象
     */
    public ExtClasspathAnnotationApplicationContext(String packageName) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.packageName = packageName;
        initBean();
    }

    public Object getBean(String beanId) throws IllegalAccessException {
        /*1.判断beanId是否为空*/
        if (StringUtils.isEmpty(beanId)) {
            return null;
        }
        /*2.判断容器内是否有指定的beanId*/
        if (!beans.containsKey(beanId)) {
            return null;
        }
        /*3.根据beanId获取bean的Class字节码*/
        Object obj = beans.get(beanId);
        /******依赖注入属性*********/
        // attriAssign(obj);// 不能在初始化的过程中，必须要放在初始化完成之后，因为如果获取的属性的类型的对象还没有被实例化，那么就会报错了。
        // 依赖注入放到getBean方法中，也不好，这样的话，每次获取对象都会对属性进行赋值。
        return obj;
    }


    /**
     * 根据字节码实例化对象
     *
     * @param clazz
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private Object newInstance(Class<?> clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }


    /**
     * 初始化bean
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void initBean() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        /*********1.获取指定包下面的所有类******/
        List<Class<?>> classes = ClassUtils.getClassesByPackageName(this.packageName);
        /*******2.过滤出类头上含有指定注解的类，并把这些类放入容器中******/
        List<Class<?>> existAnnotationList = getExistAnnotation(classes);
        /********3.把过滤出来的类信息放入容器中*****/
        putCollection(existAnnotationList);
        /*必须要保证所有的bean对象，已经实例化完成*/
        initField();
    }

    /**
     * 循环处理所有实例化对象的属性。
     *
     * @throws IllegalAccessException
     */
    private void initField() throws IllegalAccessException {
        /**
         * 完成所有的bean实例对象初始化之后，在统一的处理依赖注入
         */
        if (beans != null && beans.size() > 0) {
            Collection<Object> values = beans.values();
            for (Object obj : values) {
                attriAssign(obj);
            }
        }
    }

    /**
     * 把带有指定注册类，放到bean集合中
     *
     * @param existAnnotationList
     */
    private void putCollection(List<Class<?>> existAnnotationList) throws InstantiationException, IllegalAccessException {
        beans = new ConcurrentHashMap<>(existAnnotationList.size());
        for (Class<?> clazz : existAnnotationList) {
            Object object = newInstance(clazz);
            beans.put(getBeanIdByBeanName(clazz.getSimpleName()), object);
        }
    }

    /**
     * 过滤含有指定注解的类
     *
     * @param classes
     * @return
     */
    private List<Class<?>> getExistAnnotation(List<Class<?>> classes) {
        return classes.stream().filter((clazz) -> clazz.getAnnotation(ExtService.class) == null ? false : true).collect(Collectors.toList());
    }

    /**
     * 根据bean的名称生成bean的Id
     *
     * @param name
     * @return
     */
    private String getBeanIdByBeanName(String name) {
        Character firstChart = name.charAt(0);
        return new StringBuffer().append(firstChart.toString().toLowerCase()).append(name.substring(1)).toString();
    }


    /**
     * 依赖注入的原理是：
     * 1.使用反射机制，获取所有的属性名称
     * 2.过滤含有指定注解属性，
     * 3.根据属性名称，从容器中获取指定bean
     * 4.之后再通过反射为当前对象对象进行赋值
     */
    private void attriAssign(Object object) throws IllegalAccessException {
        /******通过反射获取bean对象所有成员变量*******/
        Class<?> classInfo = object.getClass();
        Field[] fields = classInfo.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            /******过滤出携带ExtResource注解的类*******/
            ExtResource extResource = fields[i].getAnnotation(ExtResource.class);
            if (extResource != null) {
                Field field = fields[i];
                /******通过反射为属性赋值*******/
                setFieldValue(object, field);
            }
        }
    }

    /**
     * 通过反射为指定Field赋值。
     *
     * @param object
     * @param field
     * @throws IllegalAccessException
     */
    private void setFieldValue(Object object, Field field) throws IllegalAccessException {
        String fieldName = field.getName();
        /*****这里需要获取bean的实例对象，不能是Class所以，要把beans容器的Map的Value的类型改为Object，不能设置成Class****/
        /*这里刚开始不能使用getBean方法的原因是：每次getBean方法时，会实例化一个对象。*/
        Object objValue = getBean(fieldName);
        /*****因为属性为私有的， 所以要放开私有化权限****/
        field.setAccessible(true); // 允许访问私有属性
        /*第一个参数是：为哪个对象的属性；第二个参数是：属性的值*/
        field.set(object, objValue);
    }

}
