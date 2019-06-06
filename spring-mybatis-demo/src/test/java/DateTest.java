import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @projectName: spring-study
 * @packageName: PACKAGE_NAME
 * @description:
 * @author: huayang.bai
 * @date: 2019/06/06 10:58
 */
public class DateTest {

    @Test
    public void test() {
        Date date = new Date(1539299369000L);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        System.out.println(format);
    }

}
