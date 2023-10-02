package workcompass.backend.sprint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workcompass.backend.workitem.WorkItemDaoService;

@Service
public class SprintStateManagerService{
    @Autowired
    SprintDaoService sprintDaoService;
    @Autowired
    SprintStatePublisher sprintStatePublisher;
    @Autowired
    WorkItemDaoService workItemDaoService;

    private void configureSprintStateObserver(long sprintId, boolean attachCompleted){
        Sprint sprintToConfigure = sprintDaoService.getSprintById(sprintId);
        sprintStatePublisher.attachWorkItems(
                workItemDaoService.getTasksForFilters(sprintToConfigure.getSprintName(),
                        true, true, false)
        );
        if(attachCompleted)
            sprintStatePublisher.attachWorkItems(
                    workItemDaoService.getTasksForFilters(sprintToConfigure.getSprintName(),
                            false, false, true)
            );
    }

    public void deleteSprint(long sprintId, boolean deleteWorksItems) {
        if(deleteWorksItems) {
            configureSprintStateObserver(sprintId, true);
            sprintStatePublisher.deleteWorkItems();
        }
        sprintDaoService.deleteSprintById(sprintId);//getSprints().removeIf(sprint -> sprint.getSprintId().equals(sprintId));
    }

    public void updateSprint(long sprintId, String newStatus){
        Sprint sprintToClose=sprintDaoService.getSprintById(sprintId);
        configureSprintStateObserver(sprintId, false);
        sprintStatePublisher.updateWorkItemStatus();
        deleteSprint(sprintId, false);
        sprintDaoService.updateSprintStatus(sprintToClose, newStatus);
        sprintDaoService.addSprint(sprintToClose, false);
    }

    public void updateSprint(long sprintId, Sprint sprintPatch){
        // todo: handle concurrency
        Sprint sprintToUpdate=sprintDaoService.getSprintById(sprintId);
        if(sprintToUpdate.getSprintName().equals(sprintPatch.getSprintName())){
            configureSprintStateObserver(sprintId, true);
            sprintStatePublisher.updateWorkItemSprintName(sprintPatch.getSprintName());
        }
        deleteSprint(sprintId, false);
        sprintPatch.setSprintId(sprintToUpdate.getSprintId());
        sprintDaoService.updateSprintStatus(sprintToUpdate, sprintPatch.getStatus());
        sprintDaoService.addSprint(sprintPatch, false);
    }
}
