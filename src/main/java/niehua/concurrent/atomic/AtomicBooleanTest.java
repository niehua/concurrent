package niehua.concurrent.atomic;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.annoations.ThreadSafe;
import niehua.concurrent.base.BaseAtomic;

import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@ThreadSafe
public class AtomicBooleanTest extends BaseAtomic {

    private static AtomicBoolean isHappened = new AtomicBoolean(false);


    public static void main(String[] args){
        BaseAtomic base = new AtomicBooleanTest();
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
