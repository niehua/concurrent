package niehua.concurrent.example.threadPool;

import niehua.concurrent.example.SingleThreadExecutorObject;

/**
 * Created by niehua.yang on 2019/3/3
 *
 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 *
 * 相当于顺序执行各个任务。
 *
 * 现行大多数GUI程序都是单线程的。Android中单线程可用于数据库操作，文件操作，应用批量安装，
 * 应用批量删除等不适合并发但可能IO阻塞性及影响UI线程响应的操作。
 */

public class SingleThreadExecutorTest extends BaseThreadPool implements SingleThreadExecutorObject {

    public static void main(String[] args) {
        new SingleThreadExecutorTest().run(exec, 10);
        exec.shutdown();
    }
}
