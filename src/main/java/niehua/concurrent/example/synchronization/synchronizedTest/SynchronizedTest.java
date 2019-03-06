package niehua.concurrent.example.synchronization.synchronizedTest;

/**
 * Created by niehua.yang on 2019/3/3
 *
 * 线程安全的
 *
 * Lock: 依赖特殊的 CPU 指令,代码实现
 *
 * synchronized: 不可中断锁，适合竞争不激烈，可读性好
 * Lock: 可中断锁，多样化同步，竞争激烈时能维持常态
 * Atomic: 竞争激烈时能维持常态，比Lock性能好; 只能同步一个值
 */

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.annoations.ThreadSafe;
import niehua.concurrent.example.BaseLogic;

@Slf4j
@ThreadSafe
public class SynchronizedTest extends BaseLogic {

    public static int count = 0;

    public static void main(String[] args) {
        BaseLogic baseLogic = new SynchronizedTest();
        baseLogic.execute();
    }

    @Override
    protected synchronized void run() {
        count++;
    }

    @Override
    protected long result() {
        return count;
    }

}
