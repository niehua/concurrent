package niehua.concurrent.example.UnsafeApi.dateFormat;

/**
 * Create by niehua.yang on  2019/1/20.
 */

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.BaseLogic;
import niehua.concurrent.example.annoations.NotThreadSafe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@NotThreadSafe
public class ShareUnsafeDateFormatTest extends BaseLogic {

    private AtomicInteger successTimes = new AtomicInteger(0);//解析成功次数
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

    public static void main(String[] args){
        BaseLogic baseLogic = new ShareUnsafeDateFormatTest();
        baseLogic.execute();
    }

    @Override
    protected void run() throws ParseException{
        simpleDateFormat.parse("20190120");
        successTimes.incrementAndGet();
    }

    @Override
    protected  long result(){
        return successTimes.get();
    }
}
