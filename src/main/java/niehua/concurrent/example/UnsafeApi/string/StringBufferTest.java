package niehua.concurrent.example.UnsafeApi.string;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.BaseLogic;
import niehua.concurrent.example.annoations.ThreadSafe;

@Slf4j
@ThreadSafe
public class StringBufferTest extends BaseLogic{

    private final StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args){
        BaseLogic baseLogic = new StringBufferTest();
        baseLogic.execute();
    }

    @Override
    protected void run() {
        stringBuffer.append("1");
    }

    @Override
    protected long result(){
        return  stringBuffer.length();
    }
}
