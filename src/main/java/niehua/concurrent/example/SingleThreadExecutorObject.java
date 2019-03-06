package niehua.concurrent.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by niehua.yang on 2019/3/3
 */

public interface SingleThreadExecutorObject {
    ExecutorService exec = Executors.newSingleThreadExecutor();
}
