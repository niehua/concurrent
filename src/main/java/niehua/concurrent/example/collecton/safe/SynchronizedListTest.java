package niehua.concurrent.example.collecton.safe;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.annoations.ThreadSafe;
import niehua.concurrent.example.BaseHaveOrderLogic;

import java.util.Collections;
import java.util.List;

@Slf4j
@ThreadSafe
public class SynchronizedListTest extends BaseHaveOrderLogic {

    private final List<Integer> list = Collections.synchronizedList(Lists.newArrayList());

    public static void main(String[] args){
        BaseHaveOrderLogic baseHaveOrderLogic = new SynchronizedListTest();
        baseHaveOrderLogic.execute();

    }

    @Override
    protected  void run(int order) {
        list.add(order);
    }

    @Override
    protected  long result(){
        return list.size();
    }
}
