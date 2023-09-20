package workcompass.backend.issue;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class IssueStatus {
    static final Integer NEW=0;
    static final Integer IN_PROGRESS=1;
    static final Integer RESOLVED=2;

    public int getStatusCode(String statusName){
        if(statusName.equals("NEW"))
            return NEW;
        else if(statusName.equals("IN PROGRESS"))
            return IN_PROGRESS;
        else if(statusName.equals("RESOLVED"))
            return RESOLVED;
        return -1;
    }
}
