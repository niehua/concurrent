package niehua.concurrent.example.callAble;

/**
 * Created by niehua.yang on 2019/1/22
 *
 * FutureTask<String> 是原始Thread执行的结果
 * FutureTask<V> implements RunnableFuture<V>
 *                               RunnableFuture<V>  extends Runnable, Future<V>
 */

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

@Slf4j
public class FutureTaskTest {

    public static void main(String[] args) throws Exception {
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                log.info("do something in callable");
                return "Done";
            }
        });
        new Thread(futureTask).start();

        Thread.sleep(1000);
        log.info("do something in main");
        String result = futureTask.get();//会阻塞主线程
        log.info("result：{}", result);
    }
}
