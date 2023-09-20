package workcompass.backend.workitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkItemController {
    @Autowired
    private WorkItemDaoService workItemDaoService;

    // /workItems?sprint=xyz&assignee=abc&status=open
    @GetMapping(value = "/workItems")
    public List<WorkItem> getWorkItemsList(@RequestParam String sprintName, @RequestParam String assignee,
                                       @RequestParam boolean newFilter, @RequestParam boolean ongoingFilter,
                                       @RequestParam boolean completedFilter){
        return workItemDaoService.getTasksForFilters(sprintName, assignee, newFilter, ongoingFilter, completedFilter);
    }

    @GetMapping(value = "/workItems/{workItemId}")
    public WorkItem getWorkItemForId(@PathVariable int workItemId){
        return workItemDaoService.getWorkItemForId(workItemId);
    }

    @PostMapping(value = "/workItems/addWorkItem")
    public void addWorkItem(@RequestBody WorkItem newWorkItem){
        workItemDaoService.addWorkItem(newWorkItem, true);
    }

    @DeleteMapping(value = "/workItems/deleteWorkItem/{workItemId}")
    public void deleteWorkItem(@PathVariable int workItemId){
        workItemDaoService.deleteWorkItem(workItemId);
    }

    @PatchMapping(value = "/workItems/editWorkItem/{workItemId}")
    public void updateSprint(@RequestParam String updateType, @RequestParam String newStatus,
                             @PathVariable int workItemId, @RequestBody WorkItem workItemPatch){
        // todo: have a put request for content update
        if(updateType.equalsIgnoreCase("status"))
            workItemDaoService.updateWorkItem(workItemId, newStatus);
        else if(updateType.equalsIgnoreCase("content"))
            workItemDaoService.updateWorkItem(workItemId, workItemPatch);
    }

    @GetMapping(value = "/workItems/countByType")
    public long countWorkItems(@RequestParam String userName, @RequestParam Integer sprintId,
                               @RequestParam String status){
        if(sprintId==-1)
            return workItemDaoService.countWorkItems(userName, status);
        return workItemDaoService.countWorkItems(userName, sprintId, status);
    }
}
