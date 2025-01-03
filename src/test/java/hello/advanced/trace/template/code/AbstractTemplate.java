package hello.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {
    public void execute() {
        long startTime = System.currentTimeMillis();
        // start Business Logic
        call(); // extends
        // end
        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;
        log.info("result Time = {}", resultTime);
    }

    protected abstract void call();
}
