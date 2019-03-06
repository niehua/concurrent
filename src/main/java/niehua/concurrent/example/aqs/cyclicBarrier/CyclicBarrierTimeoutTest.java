package niehua.concurrent.example.aqs.cyclicBarrier;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.aqs.BaseCyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
public class CyclicBarrierTimeoutTest extends BaseCyclicBarrier {

    public static void main(String[] args) throws InterruptedException{

        BaseCyclicBarrier cyclicBarrier = new CyclicBarrierTimeoutTest();
        cyclicBarrier.execute();
    }

    @Override
    protected void run(int order) throws InterruptedException, BrokenBarrierException {
        Thread.sleep(1000);
        log.info("{} is ready", order);
        try {
            barrier.await(2000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            log.warn("TimeoutException", e);
        }
        log.info("{} continue", order);
    }
}
