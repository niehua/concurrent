package niehua.concurrent.example.collecton.concurrent;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.annoations.ThreadSafe;
import niehua.concurrent.example.BaseHaveOrderLogic;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

@Slf4j
@ThreadSafe
public class ConcurrentSkipListSetTest extends BaseHaveOrderLogic {

    private final Set<Integer> set = new ConcurrentSkipListSet<>();

    public static void main(String[] args){
        BaseHaveOrderLogic baseHaveOrderLogic = new ConcurrentSkipListSetTest();
        baseHaveOrderLogic.execute();

    }

    @Override
    protected  void run(int order) {
        set.add(order);
    }

    @Override
    protected  long result(){
        return set.size();
    }

}
