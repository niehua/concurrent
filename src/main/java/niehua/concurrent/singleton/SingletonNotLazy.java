package niehua.concurrent.singleton;


import niehua.concurrent.annoations.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类装载时进行创建
 */
@ThreadSafe
public class SingletonNotLazy {

    // 私有构造函数
    private SingletonNotLazy() {

    }

    // 单例对象
    private static SingletonNotLazy instance = new SingletonNotLazy();

    // 静态的工厂方法
    public static SingletonNotLazy getInstance() {
        return instance;
    }
}
