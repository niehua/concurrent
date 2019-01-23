package niehua.concurrent.atomic;


import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.annoations.ThreadSafe;
import niehua.concurrent.base.BaseAtomic;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@ThreadSafe
public class AtomicIntegerTest extends BaseAtomic {

    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
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
