package hello.advanced.app.trace;

public class TraceStatus {
    private TraceId traceId;
    private Long startTimeMs; // 로그 시작 시간, 종료 시에도 사용.
    private String message;

    public TraceStatus(TraceId traceId, Long startTimeMs, String message) {
        this.traceId = traceId;
        this.startTimeMs = startTimeMs;
        this.message = message;
    }

    public TraceId getTraceId() {
        return traceId;
    }

    public Long getStartTimeMs() {
        return startTimeMs;
    }

    public String getMessage() {
        return message;
    }
}
