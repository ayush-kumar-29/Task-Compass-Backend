package workcompass.backend.sprint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workcompass.backend.workitem.WorkItem;
import workcompass.backend.workitem.WorkItemDaoService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SprintStatePublisher {
    @Autowired
    WorkItemDaoService workItemDaoService;
    private List<WorkItem> workItems;

    SprintStatePublisher(){
        this.workItems=new ArrayList<>();
    }

    public void attachWorkItems(List<WorkItem> tasks){
        this.workItems.addAll(tasks);
    }

    public void updateWorkItemStatus(){
        for(WorkItem workItem : workItems)
            workItemDaoService.updateWorkItem(workItem.getWorkItemId(), "COMPLETED");
    }

    public void updateWorkItemSprintName(String newSprintName){
        for(WorkItem workItem : workItems)
            workItemDaoService.updateWorkItemSprintName(workItem.getWorkItemId(), newSprintName);
    }

    public void deleteWorkItems(){
        for(WorkItem workItem : workItems)
            workItemDaoService.deleteWorkItem(workItem.getWorkItemId());
    }


}
