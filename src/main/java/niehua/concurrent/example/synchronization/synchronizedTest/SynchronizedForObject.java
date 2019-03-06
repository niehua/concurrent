package niehua.concurrent.example.synchronization.synchronizedTest;

/**
 * Create by niehua.yang on  2019/1/20.
 *
 * 两个线程调用两个不同的锁，所以线程之间独立，
 * 两个线程同时或交替执行
 */

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.CachedThreadPoolObeject;

/*
synchronized: 依赖 JVM
 */
@Slf4j
public class SynchronizedForObject implements CachedThreadPoolObeject {

    // 修饰一个代码块
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} - {}", j, i);
            }
        }
    }

    // 修饰一个普通方法, 相当于对象锁
    public synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} - {}", j, i);
        }
    }

    public static void main(String[] args) {
        SynchronizedForObject obj1 = new SynchronizedForObject();
        SynchronizedForObject obj2 = new SynchronizedForObject();

        exec.execute(() -> {
            obj1.test1(1);
        });
        exec.execute(() -> {
            obj2.test1(2);
        });
    }
}
