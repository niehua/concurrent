package niehua.concurrent.example.collecton.safe;

import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.annoations.ThreadSafe;
import niehua.concurrent.example.BaseHaveOrderLogic;

import java.util.Collections;
import java.util.Set;

@Slf4j
@ThreadSafe
public class SynchronizedSetTest extends BaseHaveOrderLogic {
    private final Set<Integer> set = Collections.synchronizedSet(Sets.newHashSet());

    public static void main(String[] args){
        BaseHaveOrderLogic baseHaveOrderLogic = new SynchronizedSetTest();
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
