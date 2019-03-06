package niehua.concurrent.example.threadLocal;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.CachedThreadPoolObeject;
import niehua.concurrent.example.aqs.countDownLatch.CountDownLatchTest;

import java.util.concurrent.CountDownLatch;

/**
 * Created by niehua.yang on 2019/3/6
 * <p>
 * 场景：当很多线程需要多次使用同一个对象，并且需要该对象具有相同初始化值的时候，变量是同一个，
 * 但是每个线程都使用同一个初始值，也就是使用同一个变量的一个新的副本。这种情况之下ThreadLocal就非常使用，
 * 比如说DAO的数据库连接，我们知道DAO是单例的，那么他的属性Connection就不是一个线程安全的变量。而我们每个线程都需要使用他，
 * 并且各自使用各自的。这种情况，ThreadLocal就比较好的解决了这个问题。
 * <p>
 * 本质：每个当前线程中都维护了一个ThreadLocalMap，而这个map的key就是threadLocal，
 * 而值就是我们set的那个值，每次线程在get的时候，都从自己的变量中取值，既然从自己的变量中取值，
 * 那肯定就不存在线程安全问题，
 *
 * 如果是基本数据，直接赋值就行，如果是引用，这时就需要ThreadLocal,并且需要克隆才能生成副本。
 */

@Slf4j
public class ThreadLocalTest implements CachedThreadPoolObeject, Cloneable {

    private static final ThreadLocalTest ins = new ThreadLocalTest();//充当每个线程的同一个初始值
    private static final CountDownLatch countdown = new CountDownLatch(2);

    public static void main(String[] args) {
        log.info("main start");

        for(int i=0; i < 2; i++){
            exec.execute(() -> {
                ins.run();
            });
        }
        try{
            countdown.await();
        }catch (Exception e){}
        exec.shutdown();
        log.info("main end");
    }
    private void run(){
        ThreadLocal<ThreadLocalTest> threadLocal = new ThreadLocal<>();
        threadLocal.set(ins);
        log.info("map1: {}", threadLocal.get().toString());
        threadLocal.remove();
        try {
            threadLocal.set((ThreadLocalTest) ins.clone());
            log.info("map2: {}", threadLocal.get().toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        countdown.countDown();
    }
}
