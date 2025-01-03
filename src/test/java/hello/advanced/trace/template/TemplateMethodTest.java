package hello.advanced.trace.template;

import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        // start Business Logic
        log.info("Start Business Logic1");
        // end
        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;
        log.info("result Time = {}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        // start Business Logic
        log.info("Start Business Logic2");
        // end
        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;
        log.info("result Time = {}", resultTime);
    }

    /**
     * Use Template Method Pattern
     */
    @Test
    void template_method_v1() {
        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();

        AbstractTemplate template2 = new SubClassLogic2();
        template2.execute();
    }

    /**
     * use anonymous inner class
     */
    @Test
    void template_method_v2() {
        AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("Start Business Logic1");
            }
        };
        log.info("Class name = {}", template1.getClass()); // TemplateMethodTest$1

        template1.execute();

        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("Start Business Logic2");
            }
        };
        log.info("Class name = {}", template2.getClass()); // TemplateMethodTest$2

        template2.execute();
    }
}
