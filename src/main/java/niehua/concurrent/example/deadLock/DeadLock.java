package niehua.concurrent.example.deadLock;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.CachedThreadPoolObeject;

/**
 * 一个简单的死锁类
 * 当DeadLock类的对象flag==1时（td1），先锁定o1,睡眠500毫秒
 * 而td1在睡眠的时候另一个flag==0的对象（td2）线程启动，先锁定o2,睡眠500毫秒
 * td1睡眠结束后需要锁定o2才能继续执行，而此时o2已被td2锁定；
 * td2睡眠结束后需要锁定o1才能继续执行，而此时o1已被td1锁定；
 * td1、td2相互等待，都需要得到对方锁定的资源才能继续执行，从而死锁。
 */

@Slf4j
public class DeadLock implements  CachedThreadPoolObeject {

    //静态对象是类的所有对象共享的
    private final static Object o1 = new Object(), o2 = new Object();

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();

        //t1,t2线程都处于可执行状态，但JVM线程调度先执行哪个线程是不确定的，t2可能在t1之前运行
        exec.execute(() -> {
            deadLock.run(o1, o2);
        });
        log.info("t1已启动");

        exec.execute(() -> {
            deadLock.run(o2, o1);
        });
        log.info("t2已启动");

        //不要关闭线程池
    }
    private void run(Object var1, Object var2){
        for(;;){
            synchronized (var1) {
                try {
                    Thread.sleep(3000);//模拟任务执行耗时，同时也保证了另一个线程拿到了o2锁。
                    log.info("已进入o1锁");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (var2) {
                    log.info("已进入o2锁");
                }
            }
        }
    }
}
