package niehua.concurrent.count;

import com.mmall.concurrency.ConcurrencyTest;
import com.mmall.concurrency.annoations.ThreadSafe;
import com.mmall.concurrency.example.base.BaseConcurrency;
import lombok.extern.slf4j.Slf4j;

/*
synchronized 修正计数类方法
子类继承父类的被 synchronized 修饰方法时,是没有 synchronized 修饰的!!!
Lock: 依赖特殊的 CPU 指令,代码实现


synchronized: 不可中断锁，适合竞争不激烈，可读性好
Lock: 可中断锁，多样化同步，竞争激烈时能维持常态
Atomic: 竞争激烈时能维持常态，比Lock性能好; 只能同步一个值
 */
@Slf4j
@ThreadSafe
public class CountSync extends BaseConcurrency {

    public static int count = 0;

    public static void main(String[] args){
        BaseConcurrency base = new ConcurrencyTest();
        base.execute();
    }

    @Override
    protected synchronized void add() {
        addSync();
    }

    @Override
    protected long print() {
        return count;
    }

    private synchronized static void addSync() {
        count++;
    }
}
