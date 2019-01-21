package niehua.concurrent.singleton;

import com.mmall.concurrency.annoations.NotThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 */
@NotThreadSafe
public class SingletonLazy {

    // 私有构造函数
    private SingletonLazy() {

    }
    // 单例对象
    private static SingletonLazy instance = null;
    // 静态的工厂方法
    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
