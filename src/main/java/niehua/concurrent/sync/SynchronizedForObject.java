package niehua.concurrent.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
synchronized: 依赖 JVM
 */
@Slf4j
public class SynchronizedForObject {

    // 修饰代码块
    public void test1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} ",  i);
            }
        }
    }

    // 修饰方法
    public synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            log.info("test2 {}", i);
        }
    }

    public static void main(String[] args) {
        SynchronizedForObject obj1 = new SynchronizedForObject();
        SynchronizedForObject obj2 = new SynchronizedForObject();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            obj1.test1();
        });
        executorService.execute(() -> {
            obj2.test2();
        });
    }
}
