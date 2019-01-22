package niehua.concurrent.aqs;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.base.BaseCountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class CountDownLatchExample1 extends BaseCountDownLatch{

    public static void main(String[] args){

        BaseCountDownLatch countDownLatch = new CountDownLatchExample1();
        countDownLatch.execute();
    }

    @Override
    protected void test(int threadNum) throws InterruptedException {
        Thread.sleep(100);
        log.info("{}", threadNum);
        Thread.sleep(100);
    }
}
