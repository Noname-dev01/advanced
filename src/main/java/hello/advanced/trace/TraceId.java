package hello.advanced.trace;

import java.util.UUID;

public class TraceId {

    private String id;
    private int level;

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    private TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    private String createId() {
        //UUID 전부 다 사용하면 너무 길기떄문에 substring으로 짤라서 앞 8자리만 사용
        //짤라서 사용하면 간혹 중복이 되긴하는데 로그추적기여서 크게 문제가 되지는 않는다.
        return UUID.randomUUID().toString().substring(0,8);
    }

    public TraceId createNextId() {
        return new TraceId(id, level+1);
    }
    public TraceId createPreviousId() {
        return new TraceId(id, level-1);
    }
    public boolean isFirstLevel() {
        return level == 0;
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }
}
