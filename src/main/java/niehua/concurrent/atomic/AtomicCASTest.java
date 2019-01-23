package niehua.concurrent.atomic;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.annoations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

/*
CAS 的思想，即：比较和交换。
概念：每次更新前对数据做一次比较，相同则进行更新，否则说明这条记录被其他线程修改过了，那么就不进行修改。
相当于CAS是乐观锁的一种实现方式（比较当前值跟传入值是否一样，一样则更新，否则失败）。
 */
@Slf4j
@ThreadSafe
public class AtomicCASTest {

    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0, 2); // 2
        count.compareAndSet(0, 1); // no
        count.compareAndSet(1, 3); // no
        count.compareAndSet(2, 4); // 4
        count.compareAndSet(3, 5); // no
        log.info("count:{}", count.get());
    }
}
