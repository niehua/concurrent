package niehua.concurrent.atomic;


import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.annoations.ThreadSafe;
import niehua.concurrent.base.BaseAtomic;

import java.util.concurrent.atomic.AtomicLong;

/*
提供了互斥访问，同一时刻只能有一个线程来对它进行操作
 */
@Slf4j
@ThreadSafe
public class AtomicLongTest extends BaseAtomic {

    /**
     * 工作内存
     */
    public static AtomicLong count = new AtomicLong(0);

    public static void main(String[] args){
        BaseAtomic base = new AtomicLongTest();
        base.execute();
    }

    @Override
    protected void add() {
        count.incrementAndGet();
        // count.getAndIncrement();
    }

    @Override
    protected long print() {
        return count.get();
    }
}
