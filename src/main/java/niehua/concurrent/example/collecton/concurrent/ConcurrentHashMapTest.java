package niehua.concurrent.example.collecton.concurrent;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.annoations.ThreadSafe;
import niehua.concurrent.example.BaseHaveOrderLogic;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@ThreadSafe
public class ConcurrentHashMapTest extends BaseHaveOrderLogic {

    private final Map<Integer, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args){
        BaseHaveOrderLogic baseHaveOrderLogic = new ConcurrentHashMapTest();
        baseHaveOrderLogic.execute();

    }

    @Override
    protected  void run(int order) {
        map.put(order, order);
    }

    @Override
    protected  long result(){
        return  map.size();
    }

}
