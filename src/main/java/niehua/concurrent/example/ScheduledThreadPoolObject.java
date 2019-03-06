package niehua.concurrent.example;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by niehua.yang on 2019/3/3
 */

public interface ScheduledThreadPoolObject {
    ScheduledExecutorService exec = Executors.newScheduledThreadPool(5);
}
