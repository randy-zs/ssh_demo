package test_redis;

import com.springmvc.service.RedisTestService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by randy on 17-4-17.
 */
public class RedisTestServiceTest extends SpringTestCase {

    @Autowired
    private RedisTestService redisTestService;

    @Test
    public void getTimestampTest() throws InterruptedException {
        System.out.println("第一次调用：" + redisTestService.getTimestamp("param"));
        Thread.sleep(2000);
        System.out.println("2秒之后调用：" + redisTestService.getTimestamp("param"));
        Thread.sleep(11000);
        System.out.println("再过11秒之后调用：" + redisTestService.getTimestamp("param"));
    }
}
