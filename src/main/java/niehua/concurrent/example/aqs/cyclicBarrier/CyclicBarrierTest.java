package niehua.concurrent.example.aqs.cyclicBarrier;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.aqs.BaseCyclicBarrier;

import java.util.concurrent.BrokenBarrierException;

@Slf4j
public class CyclicBarrierTest extends BaseCyclicBarrier {

    public static void main(String[] args) throws InterruptedException {
        BaseCyclicBarrier cyclicBarrier = new CyclicBarrierTest();
        cyclicBarrier.execute();
    }

    @Override
    protected void run(int order) throws InterruptedException, BrokenBarrierException {

        Thread.sleep(1000);
        log.info("{} is ready", order);
        barrier.await();
        log.info("{} continue", order);
    }
}
