package niehua.concurrent.atomic;

import com.mmall.concurrency.annoations.ThreadSafe;
import com.mmall.concurrency.example.base.BaseConcurrency;
import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.annoations.ThreadSafe;

import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@ThreadSafe
public class AtomicBooleanTest extends BaseConcurrency {

    private static AtomicBoolean isHappened = new AtomicBoolean(false);


    public static void main(String[] args){
        BaseConcurrency base = new AtomicBooleanTest();
        base.execute();
    }

    @Override
    protected void add() {
        if (isHappened.compareAndSet(false, true)) {
            log.info("execute");
        }
    }

    @Override
    protected long print() {
        return isHappened.get() ? 1 : 0;
    }
}
