package niehua.concurrent.example.aqs.countDownLatch;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.aqs.BaseCountDownLatch;

@Slf4j
public class CountDownLatchTest extends BaseCountDownLatch {

    public static void main(String[] args) {
        BaseCountDownLatch countDownLatch = new CountDownLatchTest();
        countDownLatch.execute();
    }

    @Override
    protected void run(int order)  throws InterruptedException{
        Thread.sleep(1000);
        log.info("{}", order);
    }

    @Override
    protected void await() throws InterruptedException {
        countDownLatch.await();
    }
}
