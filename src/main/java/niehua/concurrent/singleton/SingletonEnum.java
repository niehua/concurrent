package niehua.concurrent.singleton;


import niehua.concurrent.annoations.Recommend;
import niehua.concurrent.annoations.ThreadSafe;

/**
 * 枚举模式：最安全
 */
@ThreadSafe
@Recommend
public enum SingletonEnum {
    INSTANCE;
}
