package niehua.concurrent.aqs;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.base.BaseCyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class CyclicBarrierExample1 extends BaseCyclicBarrier {

    public static void main(String[] args) throws InterruptedException {
        BaseCyclicBarrier cyclicBarrier = new CyclicBarrierExample1();
        cyclicBarrier.execute();
    }

    @Override
    protected  void race(int threadNum) throws Exception {
        CyclicBarrier barrier = new CyclicBarrier(5);

        Thread.sleep(1000);
        log.info("{} is ready", threadNum);
        barrier.await();
        log.info("{} continue", threadNum);
    }
}
