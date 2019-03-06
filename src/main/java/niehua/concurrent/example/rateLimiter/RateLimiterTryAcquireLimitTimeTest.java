package niehua.concurrent.example.rateLimiter;

/**
 * Created by niehua.yang on 2019/3/3
 */

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class RateLimiterTryAcquireLimitTimeTest {

    private static RateLimiter rateLimiter = RateLimiter.create(5);//希望每秒不超过5个

    public static void main(String[] args){

        for (int index = 0; index < 100; index++) {
            if (rateLimiter.tryAcquire(190, TimeUnit.MILLISECONDS)) {
                handle(index);
            }
        }
    }

    private static void handle(int i) {
        log.info("{}", i);
    }
}
