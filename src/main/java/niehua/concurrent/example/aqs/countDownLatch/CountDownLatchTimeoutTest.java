package niehua.concurrent.example.aqs.countDownLatch;

/**
 * Created by niehua.yang on 2019/1/22
 *
 * 指定时间内处理任务
 *
 */

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.aqs.BaseCountDownLatch;

import java.util.concurrent.TimeUnit;


@Slf4j
public class CountDownLatchTimeoutTest extends BaseCountDownLatch {

    public static void main(String[] args) {

        BaseCountDownLatch countDownLatch = new CountDownLatchTimeoutTest();
        countDownLatch.execute();
    }

    @Override
    protected void run(int order) throws InterruptedException{
        Thread.sleep(1000);
        log.info("{}", order);
    }

    @Override
    protected void await() throws InterruptedException {
        //使线程在指定的最大时间单位内进入WAITING状态，
        // 如果超过这个时间则自动唤醒，程序继续向下运行。参数timeout是等待的时间，而unit参数是时间的单位。
        countDownLatch.await(500, TimeUnit.MILLISECONDS);//毫秒
    }


}
