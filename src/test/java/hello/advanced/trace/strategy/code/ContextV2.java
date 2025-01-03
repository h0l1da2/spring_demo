package hello.advanced.trace.strategy.code;

import lombok.extern.slf4j.Slf4j;

/**
 * save strategy in parameter
 */
@Slf4j
public class ContextV2 {

    public void execute(Strategy strategy) {
        long startTime = System.currentTimeMillis();
        // start Business Logic
        strategy.call(); // implements
        // end
        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;
        log.info("result Time = {}", resultTime);
    }
}
