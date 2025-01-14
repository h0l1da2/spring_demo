package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.template.Callback;
import hello.advanced.trace.strategy.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    /**
     * template callback pattern
     */
    @Test
    void callbackV1() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(new Callback() {
            @Override
            public void call() {
                log.info("business logic1 start");
            }
        });

        template.execute(new Callback() {
            @Override
            public void call() {
                log.info("business logic2 start");
            }
        });
    }

    /**
     * Lamda
     */
    @Test
    void callbackV2() {
        TimeLogTemplate template = new TimeLogTemplate();

        template.execute(() -> log.info("business logic1 start"));
        template.execute(() -> log.info("business logic2 start"));
    }
}
