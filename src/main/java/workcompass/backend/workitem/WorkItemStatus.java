package workcompass.backend.workitem;

import org.springframework.stereotype.Component;

@Component
public class WorkItemStatus {
    static final Integer NEW=0;
    static final Integer ONGOING=1;
    static final Integer COMPLETED=2;

    public int getStatusCode(String statusName){
        if(statusName.equals("NEW"))
            return NEW;
        else if(statusName.equals("ONGOING"))
            return ONGOING;
        else if(statusName.equals("COMPLETED"))
            return COMPLETED;
        return -1;
    }
}
