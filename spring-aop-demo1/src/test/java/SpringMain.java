import com.baihy.config.AopConfig;
import com.baihy.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @projectName: spring-study
 * @packageName: PACKAGE_NAME
 * @description:
 * @author: huayang.bai
 * @date: 2019/07/18 15:57
 */
public class SpringMain {

    @Test
    public void testAop() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.query();
    }

}
