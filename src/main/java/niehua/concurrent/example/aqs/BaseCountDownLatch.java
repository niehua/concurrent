package niehua.concurrent.example.aqs;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.CachedThreadPoolObeject;

import java.util.concurrent.CountDownLatch;

/**
 * Created by niehua.yang on 2019/1/22
 *
 * 闭锁对象
 *
 *      CountDownLatch是一个同步工具类，它允许一个或多个线程一直等待，直到其他线程的操作执行完后再执行
 * 例如，应用程序的主线程希望在负责启动框架服务的线程已经启动所有的框架服务之后再执行。
 *
 *      CountDownLatch是通过一个计数器来实现的，计数器的初始值为线程的数量。每当一个线程完成了自己的任务后，
 * 计数器的值就会减1。当计数器值到达0时，它表示所有的线程已经完成了任务，然后在闭锁上等待的线程就可以恢复执行任务。
 *
 *      与CountDownLatch的第一次交互是主线程等待其他线程。主线程必须在启动其他线程后立即调用CountDownLatch.await()方法。
 * 这样主线程的操作就会在这个方法上阻塞，直到其他线程完成各自的任务。
 *
 * 注意：
 *      抽象方法抛出了异常，若实现有异常则加上抛出，如没异常可以不加抛出
 */
@Slf4j
public abstract class BaseCountDownLatch implements CachedThreadPoolObeject {

    protected final CountDownLatch countDownLatch = new CountDownLatch(10);

    public void execute() {
        log.info("start");
        for (int i = 0; i < 10; i++) {
            final int order = i;
            exec.execute(() -> {
                try{
                    run(order);
                }catch (InterruptedException e){}
                countDownLatch.countDown();
            });
        }
        try {
            await();
        } catch (InterruptedException e) {
        }
        exec.shutdown();
        log.info("end");
    }

    protected abstract void run(int order) throws InterruptedException;

    protected abstract void await() throws InterruptedException;

}
