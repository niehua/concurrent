package niehua.concurrent.example.threadPool;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.FixedThreadPoolObject;

/**
 * Created by niehua.yang on 2019/3/3
 *
 * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 */

@Slf4j
public class FixedThreadPoolTest extends BaseThreadPool implements FixedThreadPoolObject {

    public static void main(String[] args) {
        new FixedThreadPoolTest().run(exec, 10);
        exec.shutdown();
    }
}
