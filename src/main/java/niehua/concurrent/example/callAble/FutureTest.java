package niehua.concurrent.example.callAble;


/**
 * Created by niehua.yang on 2019/1/22
 *
 * Future<String> 是线程池提交的结果
 *
 */

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.CachedThreadPoolObeject;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@Slf4j
public class FutureTest implements CachedThreadPoolObeject {

    static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(5000);
            log.info("do something in callable");
            return "Done";
        }
    }

    public static void main(String[] args) throws Exception {
        Future<String> future = exec.submit(new MyCallable());

        Thread.sleep(1000);
        log.info("do something in main");

        String result = future.get();//会阻塞主线程
        log.info("result：{}", result);
    }
}
