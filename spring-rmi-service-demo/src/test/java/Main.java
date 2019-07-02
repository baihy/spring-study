import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @projectName: spring-study
 * @packageName: PACKAGE_NAME
 * @description:
 * @author: huayang.bai
 * @date: 2019/07/02 15:05
 */
public class Main {

    public static void main(String[] args) {

        // 启动Spring
        new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

    }

}
