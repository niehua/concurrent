package niehua.concurrent.example.threadPool;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.CachedThreadPoolObeject;

/**
 * Created by niehua.yang on 2019/3/3
 *
 *
 * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 * 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
 */

@Slf4j
public class CachedThreadPoolTest implements CachedThreadPoolObeject {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            try {
                //Thread.sleep(threadNum * 1);//线程没复用
                Thread.sleep(threadNum * 1000);//线程复用
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            exec.execute(new Runnable() {
                @Override
                public void run() {
                    log.info("{}" , threadNum);
                }
            });
        }
        exec.shutdown();
    }
}
