package niehua.concurrent.aqs;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.base.BaseCountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
//指定时间内处理任务
@Slf4j
public class CountDownLatchExample2 extends BaseCountDownLatch {

    public static void main(String[] args) {
        BaseCountDownLatch countDownLatch = new CountDownLatchExample2();
        countDownLatch.execute();
    }

    @Override
    protected void test(int threadNum) throws InterruptedException {
        Thread.sleep(100);
        log.info("{}", threadNum);
    }
}
