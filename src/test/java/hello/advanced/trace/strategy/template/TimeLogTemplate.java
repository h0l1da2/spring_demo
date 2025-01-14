package hello.advanced.trace.strategy.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {

    public void execute(Callback callback) {
        long startTime = System.currentTimeMillis();
        // start Business Logic
        callback.call(); // implements
        // end
        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;
        log.info("result Time = {}", resultTime);
    }
}
