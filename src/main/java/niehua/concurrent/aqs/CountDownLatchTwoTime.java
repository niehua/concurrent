package niehua.concurrent.aqs;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.base.BaseCountDownLatch;

@Slf4j
public class CountDownLatchTwoTime extends BaseCountDownLatch{

    public static void main(String[] args){

        BaseCountDownLatch countDownLatch = new CountDownLatchTwoTime();
        countDownLatch.execute();
    }

    @Override
    protected void test(int threadNum) throws InterruptedException {
        Thread.sleep(100);
        log.info("{}", threadNum);
        Thread.sleep(100);
    }
}
