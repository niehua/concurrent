package niehua.concurrent.example.atomic.basicData;


import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.annoations.ThreadSafe;
import niehua.concurrent.example.BaseLogic;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@ThreadSafe
public class AtomicLongTest extends BaseLogic {

    public static AtomicLong count = new AtomicLong(0);

    public static void main(String[] args) {
        BaseLogic baseLogic = new AtomicLongTest();
        baseLogic.execute();
    }

    @Override
    protected void run() {
        count.incrementAndGet();
        // keyword.getAndIncrement();
    }

    @Override
    protected long result() {
        return count.get();
    }
}
