package workcompass.backend.sprint;

import org.springframework.stereotype.Component;

@Component
public class SprintStatus {
    static final Integer UPCOMING=0;
    static final Integer ONGOING=1;
    static final Integer CLOSED=2;

    public int getStatusCode(String statusName){
        return switch (statusName) {
            case "UPCOMING" -> UPCOMING;
            case "ONGOING" -> ONGOING;
            case "CLOSED" -> CLOSED;
            default -> -1;
        };
    }
}
