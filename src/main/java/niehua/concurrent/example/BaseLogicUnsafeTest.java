package niehua.concurrent.example;
/*
 运行发现结果随机,所以非线程安全
 */

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.annoations.NotThreadSafe;

@Slf4j
@NotThreadSafe
public class BaseLogicUnsafeTest extends BaseLogic {
    public static int count = 0;

    public static void main(String[] args) {
        BaseLogic base = new BaseLogicUnsafeTest();
        base.execute();
    }

    @Override
    protected void run() {
        count++;
    }

    @Override
    protected long result() {
        return count;
    }
}
