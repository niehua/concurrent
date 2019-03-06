package niehua.concurrent.example.synchronization.lock;

/**
 * Created by niehua.yang on 2019/3/6
 *
 * 可重入的互斥锁，又被称为“独占锁,而可重入的意思是(有一个与锁相关的获取计数器)，ReentrantLock锁，可以被单个线程多次获取
 * ReentraantLock是通过一个FIFO的等待队列来管理获取该锁所有线程的。在“公平锁”的机制下，线程依次排队获取锁；
 * 而“非公平锁”在锁是可获取状态时，不管自己是不是在队列的开头都会获取锁。
 * 默认的实现是非公平的。
 *
 * synchronized是基于JVM层面实现的，而Lock是基于JDK层面实现的。曾经反复的找过synchronized的实现，
 * 可惜最终无果。但Lock却是基于JDK实现的，我们可以通过阅读JDK的源码来理解Lock的实现。
 *
 *    使用:
 *          对于使用者的直观体验上Lock是比较复杂的，需要lock和realse，如果忘记释放锁就会产生死锁的问题，
 *    所以，通常需要在finally中进行锁的释放。支持锁获取超时，获取锁响应中断，而synchronized不支持
 *
 *          只需要对自己的方法或者关注的同步对象或类使用synchronized关键字即可，简单，
 *    但是对于锁的粒度控制比较粗，同时对于实现一些锁的状态的转移比较困难。
 */

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.BaseLogic;
import niehua.concurrent.example.annoations.ThreadSafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@ThreadSafe
public class ReentrantLockTest extends BaseLogic {


    public static int count = 0;
    private final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        BaseLogic baseLogic = new ReentrantLockTest();
        baseLogic.execute();
    }

    @Override
    protected void run() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    @Override
    protected long result() {
        return count;
    }
}
