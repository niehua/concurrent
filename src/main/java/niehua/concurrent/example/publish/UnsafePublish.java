package niehua.concurrent.example.publish;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.annoations.NotThreadSafe;

import java.util.Arrays;

@Slf4j
@NotThreadSafe
public class UnsafePublish {

    @Getter
    private String[] states = {"a", "b", "c"};

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

        //修改数组的元素
        unsafePublish.getStates()[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.getStates()));
    }
}
