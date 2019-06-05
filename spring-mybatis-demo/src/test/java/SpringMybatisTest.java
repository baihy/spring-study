import com.baihy.domain.User;
import com.baihy.service.UserService;
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
 * @date: 2019/06/05 17:54
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SpringMybatisTest {

    @Autowired
    private UserService userService;

    @Test
    public void testInsert() {
        int insert = userService.insert(new User().setUsername("admin-mybatis").setPassword("123456"));
        System.out.println(insert);
    }

}
