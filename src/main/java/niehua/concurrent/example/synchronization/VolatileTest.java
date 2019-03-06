package niehua.concurrent.example.synchronization;

/**
 * Create by niehua.yang on  2019/1/20.
 *
 * 无原子性，不安全
 */

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.annoations.NotThreadSafe;
import niehua.concurrent.example.BaseLogic;

@Slf4j
@NotThreadSafe
public class VolatileTest extends BaseLogic {

    public static volatile int count = 0;

    public static void main(String[] args) {
        BaseLogic baseLogic = new VolatileTest();
        baseLogic.execute();
    }

    @Override
    protected void run() {
        count++;
        // 1、读
        // 2、+1
        // 3、写
    }

    @Override
    protected long result() {
        return count;
    }
}
