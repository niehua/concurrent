package niehua.concurrent.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedForClass {

    // 修饰一个类
    public static void test1() {
        synchronized (SynchronizedForClass.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {}", i);
            }
        }
    }

    // 修饰一个静态方法
    public static synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} ", i);
        }
    }

    public static void main(String[] args) {
        SynchronizedForClass obj1 = new SynchronizedForClass();
        SynchronizedForClass obj2 = new SynchronizedForClass();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            obj1.test1();
        });
        executorService.execute(() -> {
            obj2.test2();
        });
    }
}
