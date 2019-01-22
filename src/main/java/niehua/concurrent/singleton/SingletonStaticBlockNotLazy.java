package niehua.concurrent.singleton;


import niehua.concurrent.annoations.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类装载时进行创建
 */
@ThreadSafe
public class SingletonStaticBlockNotLazy {

    // 私有构造函数
    private SingletonStaticBlockNotLazy() {

    }

    // 单例对象
    private static SingletonStaticBlockNotLazy instance = null;

    static {
        instance = new SingletonStaticBlockNotLazy();
    }

    // 静态的工厂方法
    public static SingletonStaticBlockNotLazy getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
