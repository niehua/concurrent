package niehua.concurrent.example;


/**
 * Created by niehua.yang on 2019/3/3
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public interface CachedThreadPoolObeject {
    ExecutorService exec = Executors.newCachedThreadPool();
}
