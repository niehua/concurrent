package niehua.concurrent.example.aqs.cyclicBarrier;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.aqs.BaseCyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Slf4j
public class CyclicBarrierTest2 extends BaseCyclicBarrier {

    private static CyclicBarrier barrier = new CyclicBarrier(5, () -> {
        log.info("callback is running");
    });

    public static void main(String[] args) throws Exception {

        BaseCyclicBarrier cyclicBarrier = new CyclicBarrierTest2();
        cyclicBarrier.execute();
    }

    @Override
    public void run(int order) throws InterruptedException, BrokenBarrierException{
        Thread.sleep(1000);
        log.info("{} is ready", order);
        barrier.await();
        log.info("{} continue", order);
    }
}
