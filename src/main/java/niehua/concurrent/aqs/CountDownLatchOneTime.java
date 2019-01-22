package niehua.concurrent.aqs;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.base.BaseCountDownLatch;

//指定时间内处理任务
@Slf4j
public class CountDownLatchOneTime extends BaseCountDownLatch {

    public static void main(String[] args) {
        BaseCountDownLatch countDownLatch = new CountDownLatchOneTime();
        countDownLatch.execute();
    }

    @Override
    protected void test(int threadNum) throws InterruptedException {
        Thread.sleep(100);
        log.info("{}", threadNum);
    }
}
