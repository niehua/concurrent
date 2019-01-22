package niehua.concurrent.singleton;


import niehua.concurrent.annoations.NotRecommend;
import niehua.concurrent.annoations.ThreadSafe;

/**
 * 同步的懒汉模式
 */
@ThreadSafe
@NotRecommend
public class SingletonSyncLazy {

    // 私有构造函数
    private SingletonSyncLazy() {

    }

    // 单例对象
    private static SingletonSyncLazy instance = null;

    // 静态的工厂方法
    public static synchronized SingletonSyncLazy getInstance() {
        if (instance == null) {
            instance = new SingletonSyncLazy();
        }
        return instance;
    }
}
