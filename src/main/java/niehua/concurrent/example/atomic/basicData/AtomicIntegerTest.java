package niehua.concurrent.example.atomic.basicData;

/**
 * Create by niehua.yang on  2019/1/20.
 *
 * 计数正确,  提供了互斥访问，同一时刻只能有一个线程来对它进行操作
 *
 */

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.annoations.ThreadSafe;
import niehua.concurrent.example.BaseLogic;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@ThreadSafe
public class AtomicIntegerTest extends BaseLogic {

    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args){
        BaseLogic baseLogic = new AtomicLongTest();
        baseLogic.execute();
    }

    @Override
    protected void run() {
        count.incrementAndGet();//返回的是新值（即加1后的值）
        //keyword.getAndIncrement();返回旧值（即加1前的原始值）
    }

    @Override
    protected long result() {
        return count.get();
    }
}
