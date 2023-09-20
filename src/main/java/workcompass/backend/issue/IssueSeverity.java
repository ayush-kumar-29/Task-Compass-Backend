package workcompass.backend.issue;

import org.springframework.stereotype.Component;

@Component
public class IssueSeverity {
    static final Integer LOW=0;
    static final Integer MEDIUM=1;
    static final Integer HIGH=2;

    public int getSeverityCode(String severityName){
        if(severityName.equals("LOW"))
            return LOW;
        else if(severityName.equals("MEDIUM"))
            return MEDIUM;
        else if(severityName.equals("HIGH"))
            return HIGH;
        return -1;
    }
}
