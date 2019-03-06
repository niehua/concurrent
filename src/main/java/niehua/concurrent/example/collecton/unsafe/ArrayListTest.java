package niehua.concurrent.example.collecton.unsafe;


import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.annoations.NotThreadSafe;
import niehua.concurrent.example.BaseHaveOrderLogic;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@NotThreadSafe
public class ArrayListTest extends BaseHaveOrderLogic {

    private final List<Integer> list = new ArrayList<>();

    public static void main(String[] args){
        BaseHaveOrderLogic baseHaveOrderLogic = new ArrayListTest();
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
