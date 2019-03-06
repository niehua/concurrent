package niehua.concurrent.example.collecton.safe;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.annoations.ThreadSafe;
import niehua.concurrent.example.BaseHaveOrderLogic;

import java.util.Hashtable;
import java.util.Map;

@Slf4j
@ThreadSafe
public class HashTableTest extends BaseHaveOrderLogic {

    private final Map<Integer, Integer> map = new Hashtable<>();

    public static void main(String[] args){
        BaseHaveOrderLogic baseHaveOrderLogic = new HashTableTest();
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
