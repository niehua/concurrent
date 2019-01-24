package niehua.concurrent.base;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.annoations.NotThreadSafe;
import niehua.concurrent.constant.NumberCons;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Create by niehua.yang on  2019/1/20.
 */
@Slf4j
@NotThreadSafe
public abstract class BaseAtomic {

    public void execute(){
        //创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，
        // 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，否则没空闲线程则会新建线程。
        ExecutorService executorService = Executors.newCachedThreadPool();
        //定义信号量,给出允许并发的线程数目
        final Semaphore semaphore = new Semaphore(NumberCons.threadTotal);
        //统计计数结果
        final CountDownLatch countDownLatch = new CountDownLatch(NumberCons.clientTotal);
        //将请求放入线程池
        for (int i = 0; i < NumberCons.clientTotal ; i++) {
            executorService.execute(() -> {
                try {
                    //信号量的获取
                    semaphore.acquire();
                    add();
                    //释放
                    semaphore.release();
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
        executorService.shutdown();
        log.info("count:{}", print());
    }

    /**
     * 统计方法
     */
    protected  abstract void add();

    /**
     * 打印
     */
    protected  abstract long print();
}
