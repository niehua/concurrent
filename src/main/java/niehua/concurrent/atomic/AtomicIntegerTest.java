package niehua.concurrent.atomic;

import com.mmall.concurrency.annoations.ThreadSafe;
import com.mmall.concurrency.example.base.BaseConcurrency;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@ThreadSafe
public class AtomicIntegerTest extends BaseConcurrency {

    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        BaseConcurrency base = new AtomicLongTest();
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
