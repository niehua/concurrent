package niehua.concurrent.example;

/**
 * Create by niehua.yang on  2019/1/20.
 *
 * 父类没用synchronized修饰的抽象方法，子类可以用synchronized修饰，使得方法变安全
 */

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.annoations.NotThreadSafe;
import java.text.ParseException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

@Slf4j
@NotThreadSafe
public abstract class BaseLogic implements CachedThreadPoolObeject {

    // 请求总数
    public int taskCount = 5000;

    // 同时并发执行的线程数
    public int threadConcurrent = 200;

    public void execute() {
        //定义信号量,给出允许并发的线程数目
        final Semaphore semaphore = new Semaphore(threadConcurrent);
        //统计计数结果
        final CountDownLatch countDownLatch = new CountDownLatch(taskCount);

        log.info("main start");
        //将请求放入线程池
        for (int i = 0; i < taskCount; i++) {
            exec.execute(() -> {
                try {
                    semaphore.acquire(); //信号量的获取
                    run();
                    semaphore.release();//释放
                } catch (ParseException | NumberFormatException e){
                    log.error("parseException : ", e);
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
    protected abstract void run() throws Exception;

    /**
     * 结果打印
     */
    protected  long result(){
        return 0;
    }
}
