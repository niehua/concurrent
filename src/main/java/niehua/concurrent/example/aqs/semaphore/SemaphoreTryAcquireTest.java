package niehua.concurrent.example.aqs.semaphore;

/**
 * Created by niehua.yang on 2019/3/4
 *
 * 尝试获取一个许可，若获取成功，则立即返回true，若获取失败，则立即返回false
 *
 * 所以：如果直接运行的话，主线程速度比较快，导致后面的7个任务都拿不到许可，最终只输出3个任务，
 * 不过如果在主线程上加上延迟可全部输出。
 */

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.aqs.BaseSemaphore;

@Slf4j
public class SemaphoreTryAcquireTest extends BaseSemaphore{

    public static void main(String[] args) {

        BaseSemaphore semaphoreIns = new SemaphoreTryAcquireTest();
        semaphoreIns.execute();
    }

    @Override
    protected  void acquire(int order) throws InterruptedException{
        if (semaphore.tryAcquire()) {
            run(order);
            semaphore.release(); // 释放一个许可
        }
    }
}
