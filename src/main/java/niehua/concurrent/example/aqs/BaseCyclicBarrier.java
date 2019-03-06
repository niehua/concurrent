package niehua.concurrent.example.aqs;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.CachedThreadPoolObeject;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by niehua.yang on 2019/1/22
 * <p>
 * CyclicBarrier是一个同步工具类，它允许一组线程互相等待，直到到达某个公共屏障点。
 * 与CountDownLatch不同的是该barrier在释放等待线程后可以重用，所以称它为循环（Cyclic）的屏障（Barrier）。
 * <p>
 * 当前线程等待直到所有线程都调用了该屏障的await()方法
 * 如果当前线程不是将到达的最后一个线程，将会被阻塞。解除阻塞的情况有以下几种
 * 1）最后一个线程调用await()
 * 2）当前线程被中断
 * 3）其他正在该CyclicBarrier上等待的线程被中断
 * 4）其他正在该CyclicBarrier上等待的线程超时
 * 5）其他某个线程调用该CyclicBarrier的reset()方法
 * 如果当前线程在进入此方法时已经设置了该线程的中断状态或者在等待时被中断，将抛出InterruptedException，并且清除当前线程的已中断状态。
 * 如果在线程处于等待状态时barrier被reset()或者在调用await()时 barrier 被损坏，将抛出 BrokenBarrierException 异常。
 * 如果任何线程在等待时被中断，则其他所有等待线程都将抛出 BrokenBarrierException 异常，并将 barrier 置于损坏状态。
 * 如果当前线程是最后一个将要到达的线程，并且构造方法中提供了一个非空的屏障操作（barrierAction），那么在允许其他线程继续运行之前，
 * 当前线程将运行该操作。如果在执行屏障操作过程中发生异常，则该异常将传播到当前线程中，并将 barrier 置于损坏状态。
 */
@Slf4j
public abstract class BaseCyclicBarrier implements CachedThreadPoolObeject {

     protected final CyclicBarrier barrier = new CyclicBarrier(5);//parties表示屏障拦截的线程数量

    public void execute() throws InterruptedException {
        log.info("start");
        for (int i = 0; i < 10; i++) {
            final int order = i;
            Thread.sleep(1500);
            exec.execute(() -> {
                try {
                    run(order);
                } catch (Exception e) {
                    log.error("exception", e);
                }
            });
        }
        exec.shutdown();
        log.info("end");
    }

    protected abstract void run(int order) throws InterruptedException, BrokenBarrierException;
}
