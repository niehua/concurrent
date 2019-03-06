package niehua.concurrent.example.synchronization.synchronizedTest;

/**
 * Create by niehua.yang on  2019/1/20.
 *
 * 两个线程调用同一个锁，所以第二个线程会在获取锁这里阻塞，
 * 只有等拿到锁的第一个线程执行完释放锁后才会继续执行
 */

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.CachedThreadPoolObeject;

@Slf4j
public class SynchronizedForClass implements CachedThreadPoolObeject {

    // 修饰一个类
    public static void test1(int j) {
        synchronized (SynchronizedForClass.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} - {}", j, i);
            }
        }
    }

    // 修饰一个静态方法，也是加类锁
    public static synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} - {}", j, i);
        }
    }

    public static void main(String[] args) {
        SynchronizedForClass obj1 = new SynchronizedForClass();
        SynchronizedForClass obj2 = new SynchronizedForClass();

        exec.execute(() -> {
            obj1.test1(1);
        });
        exec.execute(() -> {
            obj2.test1(2);
        });
    }
}
