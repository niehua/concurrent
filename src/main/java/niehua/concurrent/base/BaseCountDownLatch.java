package niehua.concurrent.base;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by niehua.yang on 2019/1/22
 */
@Slf4j
public abstract class BaseCountDownLatch {

    private final static int threadCount = 200;

    public void execute(){
        ExecutorService exec = Executors.newCachedThreadPool();

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    test(threadNum);
                } catch (Exception e) {
                    log.error("exception", e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        try{
            countDownLatch.await(10, TimeUnit.MILLISECONDS);
        }catch (InterruptedException e){}

        log.info("finish");
        exec.shutdown();
    }

    protected abstract void test(int threadNum) throws InterruptedException;

}
