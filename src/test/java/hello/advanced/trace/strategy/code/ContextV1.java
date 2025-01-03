package hello.advanced.trace.strategy.code;

import lombok.extern.slf4j.Slf4j;

/**
 * save strategy in field
 */
@Slf4j
public class ContextV1 {

    private Strategy strategy;

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        long startTime = System.currentTimeMillis();
        // start Business Logic
        strategy.call(); // implements
        // end
        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;
        log.info("result Time = {}", resultTime);
    }
}
