package niehua.concurrent;
/*
 运行发现结果随机,所以非线程安全
 */

import com.mmall.concurrency.annoations.NotThreadSafe;
import com.mmall.concurrency.example.base.BaseConcurrency;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
public class ConcurrencyTest extends BaseConcurrency {
    public static int count = 0;

    public static void main(String[] args) {
        BaseConcurrency base = new ConcurrencyTest();
        base.execute();
    }

    @Override
    protected void add() {
        count++;
    }

    @Override
    protected long print() {
        return count;
    }
}
