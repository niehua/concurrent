package niehua.concurrent.example.rateLimiter;

/**
 * Created by niehua.yang on 2019/3/3
 *
 * * RateLimiter：
 *           是guava提供的基于令牌桶算法的实现类，可以非常简单的完成限流特技，并且根据系统的实际情况来调整生成token的速率。
 *           通常可应用于抢购限流防止冲垮系统；限制某接口、服务单位时间内的访问量，譬如一些第三方服务会对用户访问量进行限制；
 *           限制网速，单位时间内只允许上传下载多少字节等。
 *
 *   有很多个任务，但希望每秒不超过X个，可用此类
 *
 */
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class RateLimiterTest {

    private static RateLimiter rateLimiter = RateLimiter.create(0.5);//每两秒执行一次任务

    public static void main(String[] args){
        for (int i = 0; i < 10; i++) {
            rateLimiter.acquire();
            log.info("{}", i);
        }
    }
}
