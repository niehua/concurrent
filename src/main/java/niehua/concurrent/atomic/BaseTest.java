package niehua.concurrent.atomic;
/*
 运行发现结果随机,所以非线程安全
 */

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.annoations.NotThreadSafe;
import niehua.concurrent.base.BaseAtomic;

@Slf4j
@NotThreadSafe
public class BaseTest extends BaseAtomic {
    public static int count = 0;

    public static void main(String[] args) {
        BaseAtomic base = new BaseTest();
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
