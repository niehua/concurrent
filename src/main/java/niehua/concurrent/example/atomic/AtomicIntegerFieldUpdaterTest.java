package niehua.concurrent.example.atomic;

/**
 * Create by niehua.yang on  2019/1/20.
 *
 * AtomicIntegerFieldUpdater就是用来更新某一个实例对象里面的int属性的。
 * 用法规则：
 *
 * 字段必须是volatile类型的，在线程之间共享变量时保证立即可见, 但volatile不保证原子性
 * 只能是实例变量，不能是类变量，
 * 只能是可修改变量，不能使final变量，因为final的语义就是不可修改。
 * 对于AtomicIntegerFieldUpdater和AtomicLongFieldUpdater只能修改int/long类型的字段，不能修改其包装类型（Integer/Long）。
 * 如果要修改包装类型就需要使用AtomicReferenceFieldUpdater。
 */

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.annoations.ThreadSafe;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
@ThreadSafe
public class AtomicIntegerFieldUpdaterTest {

    private static AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterTest> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterTest.class, "count");

    @Getter
    public volatile int count = 100;

    public static void main(String[] args) {

        AtomicIntegerFieldUpdaterTest fieldUpdater = new AtomicIntegerFieldUpdaterTest();

        if (updater.compareAndSet(fieldUpdater, 100, 120)) {
            log.info("update success 1, {}", fieldUpdater.getCount());
        } else {
            log.info("update failed  1, {}", fieldUpdater.getCount());
        }

        if (updater.compareAndSet(fieldUpdater, 100, 120)) {
            log.info("update success 2, {}", fieldUpdater.getCount());
        } else {
            log.info("update failed  2, {}", fieldUpdater.getCount());
        }
    }
}
