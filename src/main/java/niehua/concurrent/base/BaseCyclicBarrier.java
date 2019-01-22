package niehua.concurrent.base;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by niehua.yang on 2019/1/22
 */
@Slf4j
public abstract class BaseCyclicBarrier {

    public void execute() throws InterruptedException{
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            executor.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    log.error("exception", e);
                }
            });
        }
        executor.shutdown();
    }

    protected abstract void race(int threadNum) throws Exception;
}
