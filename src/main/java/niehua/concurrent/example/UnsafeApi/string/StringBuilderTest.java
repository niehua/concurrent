package niehua.concurrent.example.UnsafeApi.string;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.BaseLogic;
import niehua.concurrent.example.annoations.NotThreadSafe;

@Slf4j
@NotThreadSafe
public class StringBuilderTest extends BaseLogic {

    private final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args){
        BaseLogic baseLogic = new StringBuilderTest();
        baseLogic.execute();
    }

    @Override
    protected void run() {
        stringBuilder.append("1");
    }

    @Override
    protected long result(){
        return  stringBuilder.length();
    }
}
