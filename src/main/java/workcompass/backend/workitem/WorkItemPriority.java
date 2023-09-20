package workcompass.backend.workitem;

import org.springframework.stereotype.Component;

@Component
public class WorkItemPriority {
    static final Integer LOW=0;
    static final Integer MEDIUM=1;
    static final Integer HIGH=2;

    public int getPriorityCode(String statusName){
        return switch (statusName) {
            case "LOW" -> LOW;
            case "MEDIUM" -> MEDIUM;
            case "HIGH" -> HIGH;
            default -> -1;
        };
    }
}
