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

    private void configureSprintStateObserver(int sprintId, boolean attachCompleted){
        Sprint sprintToConfigure = sprintDaoService.getSprints().stream()
                .filter(sprint -> sprint.getSprintId() == sprintId).findAny().get();
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

    public void deleteSprint(int sprintId, boolean deleteWorksItems) {
        if(deleteWorksItems) {
            configureSprintStateObserver(sprintId, true);
            sprintStatePublisher.deleteWorkItems();
        }
        sprintDaoService.getSprints().removeIf(sprint -> sprint.getSprintId().equals(sprintId));
    }

    public void updateSprint(int sprintId, String newStatus){
        Sprint sprintToClose=sprintDaoService.getSprints().stream().filter(sprint -> sprint.getSprintId().equals(sprintId))
                .findAny().get();
        configureSprintStateObserver(sprintId, false);
        sprintStatePublisher.updateWorkItemStatus();
        deleteSprint(sprintId, false);
        sprintDaoService.updateSprintStatus(sprintToClose, newStatus);
        sprintDaoService.addSprint(sprintToClose, false);
    }

    public void updateSprint(int sprintId, Sprint sprintPatch){
        // todo: handle concurrency
        Sprint sprintToUpdate=sprintDaoService.getSprints().stream()
                .filter(sprint -> sprint.getSprintId().equals(sprintId))
                .findAny().get();
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
