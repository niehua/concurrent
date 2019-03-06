package niehua.concurrent.example.UnsafeApi.dateFormat;

/**
 * Create by niehua.yang on  2019/1/20.
 */

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.BaseHaveOrderLogic;
import niehua.concurrent.example.annoations.ThreadSafe;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

@Slf4j
@ThreadSafe
public class DateTimeSafeDateFormatTest extends BaseHaveOrderLogic {

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyyMMdd");

    public static void main(String[] args){
        BaseHaveOrderLogic baseHaveOrderLogic = new DateTimeSafeDateFormatTest();
        baseHaveOrderLogic.execute();
    }

    @Override
    protected void run(int order){
        log.info("{}, {}", order, DateTime.parse("20190120", dateTimeFormatter).toDate());
    }
}
