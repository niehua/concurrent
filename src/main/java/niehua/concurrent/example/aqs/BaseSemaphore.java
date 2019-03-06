package niehua.concurrent.example.aqs;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.CachedThreadPoolObeject;

import java.util.concurrent.Semaphore;

/**
 * Created by niehua.yang on 2019/3/4
 *
 * Semaphore(信号量)：可阻塞线程,控制同一时间段内的并发量
 */

@Slf4j
public abstract class BaseSemaphore  implements CachedThreadPoolObeject {

    protected final Semaphore semaphore = new Semaphore(3);

    public void execute() {
        log.info("start");
        for (int i = 0; i < 10; i++) {
            final int order = i;
            exec.execute(() -> {
                try {
                    acquire(order);
                } catch (Exception e) {
                    log.error("exception", e);
                }
            });
        }
        exec.shutdown();
        log.info("end");
    }

    protected abstract void acquire(int order) throws InterruptedException;

    protected void run(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        log.info("{}", threadNum);
    }
}
