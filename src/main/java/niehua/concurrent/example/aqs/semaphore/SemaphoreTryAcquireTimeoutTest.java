package niehua.concurrent.example.aqs.semaphore;

/**
 * Created by niehua.yang on 2019/3/4
 *
 * 尝试获取一个许可，若在指定的时间内获取成功，则立即返回true，否则则立即返回false
 */

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.aqs.BaseSemaphore;

import java.util.concurrent.TimeUnit;

@Slf4j
public class SemaphoreTryAcquireTimeoutTest extends BaseSemaphore{

    public static void main(String[] args){

        BaseSemaphore semaphoreIns = new SemaphoreTryAcquireTimeoutTest();
        semaphoreIns.execute();
    }

    @Override
    protected  void acquire(int order) throws InterruptedException{
        if (semaphore.tryAcquire(5000, TimeUnit.MILLISECONDS)) {
            run(order);
            semaphore.release(); // 释放一个许可
        }
    }
}
