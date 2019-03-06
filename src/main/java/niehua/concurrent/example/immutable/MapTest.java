package niehua.concurrent.example.immutable;

/**
 * Create by niehua.yang on  2019/3/5
 *
 * 可变的map
 */

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.annoations.NotThreadSafe;

import java.util.Map;

@Slf4j
@NotThreadSafe
public class MapTest {
    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
        map.put(1, 3);
        log.info("{}", map.get(1));
    }
}
