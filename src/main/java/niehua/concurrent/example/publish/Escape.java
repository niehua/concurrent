package niehua.concurrent.example.publish;

import lombok.extern.slf4j.Slf4j;
import niehua.concurrent.example.annoations.NotRecommend;
import niehua.concurrent.example.annoations.NotThreadSafe;

@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass {
        //this指针逃逸
        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
