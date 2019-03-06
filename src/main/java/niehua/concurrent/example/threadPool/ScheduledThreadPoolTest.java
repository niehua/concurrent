package niehua.concurrent.example.threadPool;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.ScheduledThreadPoolObject;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by niehua.yang on 2019/3/3
 *
 * 创建一个定长线程池，支持定时及周期性任务执行。
 */

@Slf4j
public class ScheduledThreadPoolTest implements ScheduledThreadPoolObject {

    public static void main(String[] args) {
        log.info("main start");

        log.info("delay3() start");
        delay3();

        log.info("every3() start");
        every3();

        //exec.shutdown();  线程池不能关，否则3秒执行一次的任务不能循环执行

        every5Timer();

        log.info("main end");
    }
    //表示延迟3秒执行。
    private static void delay3(){
        exec.schedule(() ->{
            log.info("{}" ,"delay 3 seconds");
            }, 3, TimeUnit.SECONDS);
    }


    //定期执行,延迟1秒后每3秒执行一次
    //ScheduledExecutorService比Timer更安全，功能更强大。
    private static void every3() {
        exec.scheduleAtFixedRate(() -> {
            log.info("{}" ,"delay 1 seconds, and excute every 3 seconds");
            }, 1, 3, TimeUnit.SECONDS);
    }

    //Timer: 每5秒执行一次
    private static void every5Timer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.warn("timer run");
            }
        }, new Date(), 5 * 1000);
    }
}
