package niehua.concurrent.example.synchronization.lock;

/**
 * Created by niehua.yang on 2019/3/6
 *
 * Condition是在java 1.5中才出现的，它用来替代传统的Object的wait()、notify()实现线程间的协作，
 * 相比使用Object的wait()、notify()，使用Condition的await()、signal()这种方式实现线程间协
 * 作更加安全和高效。因此通常来说比较推荐使用Condition。
 *
 * Condition是个接口，基本的方法就是await()和signal()方法。
 * 调用Condition的await()和signal()方法，都必须在lock保护之内，就是说必须在lock.lock()和lock.unlock之间才可以使用。
 *
 * Conditon中的await()对应Object的wait()，Condition中的signal()对应Object的notify()，Condition中的signalAll()对应Object的notifyAll()。
 */



import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ReentrantLockConditionTest {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        new Thread(() -> {
            try {
                reentrantLock.lock();
                log.info("wait signal"); // 1
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("get signal"); // 4
            reentrantLock.unlock();
        }).start();

        new Thread(() -> {
            reentrantLock.lock();
            log.info("get synchronization"); // 2
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition.signalAll();
            log.info("send signal ~ "); // 3
            reentrantLock.unlock();
        }).start();
    }
}
