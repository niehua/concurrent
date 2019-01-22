package niehua.concurrent.count;

import com.mmall.concurrency.annoations.NotThreadSafe;
import com.mmall.concurrency.example.base.BaseConcurrency;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
public class CountVolatile extends BaseConcurrency {

    public static volatile int count = 0;

    public static void main(String[] args){
        BaseConcurrency base = new CountVolatile();
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
