package niehua.concurrent.example.atomic.basicData;

/**
 * Create by niehua.yang on  2019/1/20.
 *
 * 只输出了一次，所以不存在竟态 ，读-写-读，也就是不存在多个线程同时读到 false
 */

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.annoations.ThreadSafe;
import niehua.concurrent.example.BaseLogic;

import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@ThreadSafe
public class AtomicBooleanTest extends BaseLogic {

    private static AtomicBoolean isHappened = new AtomicBoolean(false);

    public static void main(String[] args) {
        BaseLogic baseLogic = new AtomicBooleanTest();
        baseLogic.execute();
    }

    @Override
    protected void run() {
        if (isHappened.compareAndSet(false, true)) {
            log.info("execute");
        }
    }

    @Override
    protected long result() {
        return isHappened.get() ? 1 : 0;
    }
}
