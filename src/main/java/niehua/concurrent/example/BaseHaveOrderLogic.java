package niehua.concurrent.example;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * Created by niehua.yang on 2019/3/5
 */

@Slf4j
public abstract class BaseHaveOrderLogic implements CachedThreadPoolObeject {

    // 请求总数
    public int taskCount = 5000;

    // 同时并发执行的线程数
    public int threadConcurrent = 200;

    public void execute() {
        //定义信号量,给出允许并发的线程数目
        Semaphore semaphore = new Semaphore(threadConcurrent);
        //统计计数结果
        final CountDownLatch countDownLatch = new CountDownLatch(taskCount);

        log.info("main start");
        //将请求放入线程池
        for (int i = 0; i < taskCount; i++) {
            final int order = i;
            exec.execute(() -> {
                try {
                    semaphore.acquire(); //信号量的获取
                    run(order);
                    semaphore.release();//释放
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            log.error("exception", e);
        }
        //关闭线程池
        exec.shutdown();
        log.info("result:{}", result());
        log.info("main end");
    }

    /**
     * 子线程执行业务
     */
    protected abstract void run(int order);

    /**
     * 结果打印
     */
    protected long result(){
        return 0;
    }
}
