package niehua.concurrent.example.collecton.safe;


import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.annoations.ThreadSafe;
import niehua.concurrent.example.BaseHaveOrderLogic;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ThreadSafe
public class SynchronizedMapTest extends BaseHaveOrderLogic {

    private final Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<>());

    public static void main(String[] args){
        BaseHaveOrderLogic baseHaveOrderLogic = new SynchronizedMapTest();
        baseHaveOrderLogic.execute();

    }

    @Override
    protected  void run(int order) {
        map.put(order, order);
    }

    @Override
    protected  long result(){
        return map.size();
    }
}
