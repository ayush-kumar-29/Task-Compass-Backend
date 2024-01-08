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
    @Autowired
    SprintStatus sprintStatus;

    private void configureSprintStateObserver(String sprintId, boolean attachCompleted){
        Sprint sprintToConfigure = sprintDaoService.getSprintForId(sprintId);
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

    public void deleteSprint(String sprintId, boolean deleteWorksItems) {
        if(deleteWorksItems) {
            configureSprintStateObserver(sprintId, true);
            sprintStatePublisher.deleteWorkItems();
        }
        sprintDaoService.deleteSprintById(sprintId);//getSprints().removeIf(sprint -> sprint.getSprintId().equals(sprintId));
    }

    public void updateSprint(String sprintId, String newStatus){
        Sprint sprintToClose=sprintDaoService.getSprintForId(sprintId);
        configureSprintStateObserver(sprintId, false);
        sprintStatePublisher.updateWorkItemStatus();
//        deleteSprint(sprintId, false);
        sprintDaoService.updateSprintStatus(sprintToClose, newStatus);
        sprintDaoService.addSprint(sprintToClose, false);
    }

    public void updateSprint(String sprintId, Sprint sprintPatch){
        // todo: handle concurrency
        Sprint sprintToUpdate=sprintDaoService.getSprintForId(sprintId);
        if(!sprintToUpdate.getSprintName().equals(sprintPatch.getSprintName())){
            configureSprintStateObserver(sprintId, true);
            sprintStatePublisher.updateWorkItemSprintName(sprintPatch.getSprintName());
        }
//        deleteSprint(sprintId, false);
        sprintPatch.setId(sprintToUpdate.getId());
        sprintPatch.setSprintId(sprintToUpdate.getSprintId());
        sprintPatch.setIsDeleted(false);
        if(sprintToUpdate.getStatusCode()!=sprintStatus.getStatusCode(sprintPatch.getStatus())){
            configureSprintStateObserver(sprintId, false);
            sprintStatePublisher.updateWorkItemStatus();
//            updateSprint(sprintId, sprintPatch.getStatus());
        }
        sprintPatch.setStatusCode(sprintToUpdate.getStatusCode());

//        sprintDaoService.updateSprintStatus(sprintToUpdate, sprintPatch.getStatus());
        sprintDaoService.addSprint(sprintPatch, false);
    }
}
