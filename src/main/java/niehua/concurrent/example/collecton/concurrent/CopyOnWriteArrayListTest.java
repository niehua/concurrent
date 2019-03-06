package niehua.concurrent.example.collecton.concurrent;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.annoations.ThreadSafe;
import niehua.concurrent.example.BaseHaveOrderLogic;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
@ThreadSafe
public class CopyOnWriteArrayListTest extends BaseHaveOrderLogic {

    private final List<Integer> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args){
        BaseHaveOrderLogic baseHaveOrderLogic = new CopyOnWriteArrayListTest();
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
