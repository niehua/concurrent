package niehua.concurrent.example.collecton.unsafe;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.annoations.NotThreadSafe;
import niehua.concurrent.example.BaseHaveOrderLogic;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@NotThreadSafe
public class HashSetTest extends BaseHaveOrderLogic {

    private final Set<Integer> set = new HashSet<>();

    public static void main(String[] args){
        BaseHaveOrderLogic baseHaveOrderLogic = new HashSetTest();
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
