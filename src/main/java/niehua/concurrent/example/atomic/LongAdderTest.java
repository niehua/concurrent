package niehua.concurrent.example.atomic;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.BaseLogic;

import java.util.concurrent.atomic.LongAdder;

/**
 * Created by niehua.yang on 2019/3/4
 *
 * 更快的原子类:LongAdder
 *      大家对AtomicLong的基本实现机制应该比较了解,它们是在一个死循环内,不断尝试修改目标值,直到修改成功
 *      for (;;) {
 *         // 获取AtomicLong当前对应的long值
 *         long current = get();
 *         // 将current加1
 *         long next = current + 1;
 *         // 通过CAS函数，更新current的值
 *         if (compareAndSet(current, next))
 *             return next;
 *     }
 *      如果竞争不激烈,那么修改成功的概率就很高,否则,修改失败的概率就很高,在大量修改失败时,
 *      这些原子操作就会进行多次循环尝试,因此性能就会受到影响
 *
 *      那么竞争激烈的时候,我们应该如何进一步提高系统性能呢?一种基本方案就是可以使用热点分离,
 *
 *      虽然在CAS操作中没有锁,但是像减少锁粒度这种分离热点的思路依然可以使用,一种可行的方案就是仿造ConcurrengHashMap,
 *      将热点数据分离,比如,可以将AtomicInteger的内部核心数据value分离成一个数组,每个线程访问时,
 *      通过哈希等算法映射到其中一个数字进行计数,而最终的计数结果,则为这个数组的求和累加,其中,
 *      热点数据value被分离成多个单元cell,每个cell独自维护内部的值,
 *      当前对象的实际值由所有的cell累计合成,这样,热点就进行了有效的分离,提高了并行度,LongAdder正是使用了这种思想.
 */

@Slf4j
public class LongAdderTest extends BaseLogic {
    private final LongAdder count = new LongAdder();

    public static void main(String[] args){
        BaseLogic baseLogic = new LongAdderTest();
        baseLogic.execute();
    }

    @Override
    protected void run() {
        count.increment();
    }

    @Override
    protected long result(){
        log.info("count.toString:{}", count.toString());
        return  count.longValue();
    }
}
