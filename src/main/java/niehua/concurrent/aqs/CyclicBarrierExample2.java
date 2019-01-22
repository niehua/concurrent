package niehua.concurrent.aqs;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.base.BaseCyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CyclicBarrierExample2 extends BaseCyclicBarrier {

    public static void main(String[] args) throws InterruptedException {

        BaseCyclicBarrier cyclicBarrier = new CyclicBarrierExample2();
        cyclicBarrier.execute();
    }

    @Override
    protected  void race(int threadNum) throws Exception {
        CyclicBarrier barrier = new CyclicBarrier(5);

        Thread.sleep(1000);
        log.info("{} is ready", threadNum);
        try {
            barrier.await(2000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            log.warn("BarrierException", e);
        }
        log.info("{} continue", threadNum);
    }
}
