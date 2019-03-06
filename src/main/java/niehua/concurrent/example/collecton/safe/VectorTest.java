package niehua.concurrent.example.collecton.safe;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.annoations.ThreadSafe;
import niehua.concurrent.example.BaseHaveOrderLogic;
import niehua.concurrent.example.collecton.unsafe.ArrayListTest;

import java.util.List;
import java.util.Vector;

@Slf4j
@ThreadSafe
public class VectorTest extends BaseHaveOrderLogic {

    private final List<Integer> list = new Vector<>();

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
