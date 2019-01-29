package niehua.concurrent.count;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.annoations.NotThreadSafe;
import niehua.concurrent.base.BaseAtomic;

@Slf4j
@NotThreadSafe
public class CountVolatile extends BaseAtomic {

    public static volatile int count = 0;

    public static void main(String[] args){
        BaseAtomic base = new CountVolatile();
        base.execute();
    }

    @Override
    protected void add() {
        count++;
        // 1、count
        // 2、+1
        // 3、count
    }

    @Override
    protected long print() {
        return count;
    }
}
