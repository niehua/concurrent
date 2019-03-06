package niehua.concurrent.example.immutable;

/**
 * Create by niehua.yang on  2019/3/5
 *
 * 不可变的map, 用Collections.unmodifiableMap(map);
 * 包装后，如果再往容器put元素会抛出运行时异常
 */

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.annoations.ThreadSafe;

import java.util.Collections;
import java.util.Map;

@Slf4j
@ThreadSafe
public class ImmutableMapTest {

    private  static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        map = Collections.unmodifiableMap(map);//类变量map指向了这个新的map,所以不能加final修饰，否则报错
    }

    public static void main(String[] args) {
        map.put(1, 3);
        log.info("{}", map.get(1));
    }

}
