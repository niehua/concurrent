package niehua.concurrent.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;

/**
 * Created by niehua.yang on 2019/3/3
 */

@Slf4j
public abstract class BaseThreadPool {

    protected void run(ExecutorService exec, int taskCount){
        for (int i = 0; i < taskCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    Thread.sleep(2000);//模拟任务执行过程
                    log.info("{}" , threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
