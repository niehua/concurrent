package niehua.concurrent.example.collecton.unsafe;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.annoations.NotThreadSafe;
import niehua.concurrent.example.BaseHaveOrderLogic;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@NotThreadSafe
public class HashMapTest extends BaseHaveOrderLogic {
    private final Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args){
        BaseHaveOrderLogic baseHaveOrderLogic = new HashMapTest();
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
