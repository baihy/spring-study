import com.baihy.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @projectName: spring-study
 * @packageName: PACKAGE_NAME
 * @description:
 * @author: huayang.bai
 * @date: 2019/07/02 15:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class RMITest {

    @Autowired
    private HelloService helloService;


    @Test
    public void testRmi() {
        helloService.sayHello();
    }

}
