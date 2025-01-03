package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.ContextV1;
import hello.advanced.trace.strategy.code.Strategy;
import hello.advanced.trace.strategy.code.StrategyLogic1;
import hello.advanced.trace.strategy.code.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {
    @Test
    void strategyV0() {
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
     * use Strategy Pattern
     */
    @Test
    void strategyV1() {
        Strategy strategyLogic1 = new StrategyLogic1();
        ContextV1 context1 = new ContextV1(strategyLogic1);

        context1.execute();

        Strategy strategyLogic2 = new StrategyLogic2();
        ContextV1 context2 = new ContextV1(strategyLogic2);

        context2.execute();
    }

    /**
     * inner class
     */
    @Test
    void strategyV2() {
        Strategy logic1 = new Strategy() {
            @Override
            public void call() {
                log.info("Start Business Logic1");
            }
        };

        log.info("logic1 Class = {}", logic1.getClass());
        ContextV1 context1 = new ContextV1(logic1);

        context1.execute();

        Strategy logic2 = new Strategy() {
            @Override
            public void call() {
                log.info("Start Business Logic1");
            }
        };

        log.info("logic2 Class = {}", logic2.getClass());

        ContextV1 context2 = new ContextV1(logic2);

        context2.execute();
    }

    /**
     * inner class
     */
    @Test
    void strategyV3() {
        ContextV1 context1 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("Start Business Logic1");
            }
        });

        context1.execute();

        ContextV1 context2 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("Start Business Logic1");
            }
        });

        context2.execute();
    }

    /**
     * Lambda
     * just one method
     */
    @Test
    void strategyV4() {
        ContextV1 context1 = new ContextV1(() -> log.info("Start Business Logic1"));
        context1.execute();

        ContextV1 context2 = new ContextV1(() -> log.info("Start Business Logic1"));
        context2.execute();
    }
}
