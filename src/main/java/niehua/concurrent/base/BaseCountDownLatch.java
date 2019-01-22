package niehua.concurrent.base;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by niehua.yang on 2019/1/22
 *
 * 闭锁对象
 *
 * CountDownLatch是一个同步工具类，它允许一个或多个线程一直等待，直到其他线程的操作执行完后再执行
 * 例如，应用程序的主线程希望在负责启动框架服务的线程已经启动所有的框架服务之后再执行。
 *
 * CountDownLatch是通过一个计数器来实现的，计数器的初始值为线程的数量。每当一个线程完成了自己的任务后，
 * 计数器的值就会减1。当计数器值到达0时，它表示所有的线程已经完成了任务，然后在闭锁上等待的线程就可以恢复执行任务。
 *
 * 与CountDownLatch的第一次交互是主线程等待其他线程。主线程必须在启动其他线程后立即调用CountDownLatch.await()方法。
 * 这样主线程的操作就会在这个方法上阻塞，直到其他线程完成各自的任务。
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
            //使线程在指定的最大时间单位内进入WAITING状态，
            // 如果超过这个时间则自动唤醒，程序继续向下运行。参数timeout是等待的时间，而unit参数是时间的单位。
        }catch (InterruptedException e){}

        log.info("finish");
        exec.shutdown();
    }

    protected abstract void test(int threadNum) throws InterruptedException;

}
