package niehua.concurrent.example.aqs.semaphore;

/**
 * Created by niehua.yang on 2019/3/4
 *
 * 阻塞线程, 每个线程获取多个许可，如果超过信号量的大小，线程将阻塞
 */
import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.aqs.BaseSemaphore;

@Slf4j
public class SemaphoreAcquire3Test extends BaseSemaphore{

    public static void main(String[] args){

        BaseSemaphore semaphoreIns = new SemaphoreAcquire3Test();
        semaphoreIns.execute();
    }

    @Override
    protected  void acquire(int order) throws InterruptedException{
        semaphore.acquire(3); // 获取多个许可
        run(order);
        semaphore.release(3); // 释放多个许可
    }
}
