package niehua.concurrent.example.UnsafeApi.dateFormat;

/**
 * Create by niehua.yang on  2019/1/20.
 */

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.BaseLogic;
import niehua.concurrent.example.annoations.ThreadSafe;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Slf4j
@ThreadSafe
public class PrivateSafeDateFormatTest extends BaseLogic{

    public static void main(String[] args){
        BaseLogic baseLogic = new PrivateSafeDateFormatTest();
        baseLogic.execute();
    }

    @Override
    protected void run(){
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            simpleDateFormat.parse("20190120");
        }catch (ParseException e){
            log.error("parseException : {}", e);
        }
    }
}
