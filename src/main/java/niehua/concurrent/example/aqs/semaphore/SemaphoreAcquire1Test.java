package niehua.concurrent.example.aqs.semaphore;

/**
 * Created by niehua.yang on 2019/3/4
 *
 * 阻塞线程, 同一时间段内只允许运行3个线程
 */

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.aqs.BaseSemaphore;

@Slf4j
public class SemaphoreAcquire1Test extends BaseSemaphore{

    public static void main(String[] args){
        BaseSemaphore  semaphoreIns = new SemaphoreAcquire1Test();
        semaphoreIns.execute();
    }

    @Override
    protected  void acquire(int order) throws InterruptedException{
        semaphore.acquire(); // 获取一个许可
        run(order);
        semaphore.release(); // 释放一个许可
    }
}
