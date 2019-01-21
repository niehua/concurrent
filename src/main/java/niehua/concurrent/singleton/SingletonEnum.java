package niehua.concurrent.singleton;

import com.mmall.concurrency.annoations.Recommend;
import com.mmall.concurrency.annoations.ThreadSafe;

/**
 * 枚举模式：最安全
 */
@ThreadSafe
@Recommend
public enum SingletonEnum {
    INSTANCE;
}
