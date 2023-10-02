package workcompass.backend.workitem;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workcompass.backend.sprint.SprintDaoService;
import workcompass.backend.user.UserDaoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkItemDaoService {
    @Autowired
    private UserDaoService userDaoService;
    @Autowired
    private SprintDaoService sprintDaoService;
    @Autowired
    private WorkItemStatus workItemStatus;
    @Autowired
    private WorkItemPriority workItemPriority;
    @Autowired
    private WorkItemRepository workItemRepository;

//    private List<WorkItem> workItems;
//    private int workItemCount;

//    public WorkItemDaoService(UserDaoService userDaoService, SprintDaoService sprintDaoService) {
//        userDaoService = userDaoService;
//        sprintDaoService = sprintDaoService;
//    }

//    @PostConstruct
//    public void init() {
//        workItems = new ArrayList<>();
//        workItemCount = 3001;
//        workItems.add(new WorkItem(getNewWorkItemId(), "Task-1", "Task-1 Desc-1",
//                "Sprint-1", sprintDaoService.getSprintIdFromName("Sprint-1"),
//                LocalDate.now().plusDays(10), "NEW",
//                workItemStatus.getStatusCode("NEW"),
//                "LOW", workItemPriority.getPriorityCode("LOW"), "user1",
//                userDaoService.getUserIdFromName("user1"), "user2",
//                userDaoService.getUserIdFromName("user2"), LocalDate.now()));
//        workItems.add(new WorkItem(getNewWorkItemId(), "Task-1", "Task-1 Desc-1",
//                "Sprint-1", sprintDaoService.getSprintIdFromName("Sprint-1"),
//                LocalDate.now().plusDays(10), "NEW",
//                workItemStatus.getStatusCode("NEW"),
//                "LOW", workItemPriority.getPriorityCode("LOW"), "user2",
//                userDaoService.getUserIdFromName("user2"), "user3",
//                userDaoService.getUserIdFromName("user3"), LocalDate.now()));
//        workItems.add(new WorkItem(getNewWorkItemId(), "Task-1", "Task-1 Desc-1",
//                "Sprint-1", sprintDaoService.getSprintIdFromName("Sprint-1"),
//                LocalDate.now().plusDays(10), "ONGOING",
//                workItemStatus.getStatusCode("ONGOING"),
//                "LOW", workItemPriority.getPriorityCode("LOW"), "user3",
//                userDaoService.getUserIdFromName("user3"), "user1",
//                userDaoService.getUserIdFromName("user1"), LocalDate.now()));
//    }

//    private int getNewWorkItemId() {
//        return workItemCount++;
//    }

    public void addWorkItem(WorkItem newWorkItem, boolean isNewWorkItem) {
        if (isNewWorkItem) {
//            newWorkItem.setWorkItemId(getNewWorkItemId());
            newWorkItem.setStatusCode(workItemStatus.getStatusCode(newWorkItem.getStatus()));
            newWorkItem.setSprintId(sprintDaoService.getSprintIdFromName(newWorkItem.getSprint()));
            newWorkItem.setPriorityCode(workItemPriority.getPriorityCode(newWorkItem.getPriority()));
            newWorkItem.setAssigneeId(userDaoService.getUserIdFromName(newWorkItem.getAssigneeName()));
            newWorkItem.setCreatorId(userDaoService.getUserIdFromName(newWorkItem.getCreatorName()));
            newWorkItem.setCreationDate(LocalDate.now());
        }
//        workItems.add(newWorkItem);
        workItemRepository.save(newWorkItem);
    }

    public List<WorkItem> getTasksForFilters(String sprint, String assignee, boolean newFilter,
                                             boolean ongoingFilter, boolean completedFilter) {
        long assigneeId = userDaoService.getUserIdFromName(assignee);
        long sprintId = sprintDaoService.getSprintIdFromName(sprint);
        List<WorkItem> workItemList = new ArrayList<>();
        if (newFilter) {
//            workItemList.addAll(workItems.stream().filter(
//                    workItem -> workItem.getAssigneeId() == assigneeId &&
//                            workItem.getSprintId() == sprintDaoService.getSprintIdFromName(sprint) &&
//                            workItem.getStatusCode() == WorkItemStatus.NEW
//            ).toList());
            workItemList.addAll(workItemRepository.findByAssigneeIdAndSprintIdAndStatusCode(assigneeId, sprintId, WorkItemStatus.NEW));
        }
        if (ongoingFilter) {
//            workItemList.addAll(workItems.stream().filter(
//                    workItem -> workItem.getAssigneeId() == assigneeId &&
//                            workItem.getSprintId() == sprintDaoService.getSprintIdFromName(sprint) &&
//                            workItem.getStatusCode() == WorkItemStatus.ONGOING
//            ).toList());
            workItemList.addAll(workItemRepository.findByAssigneeIdAndSprintIdAndStatusCode(assigneeId, sprintId, WorkItemStatus.ONGOING));
        }
        if (completedFilter) {
//            workItemList.addAll(workItems.stream().filter(
//                    workItem -> workItem.getAssigneeId() == assigneeId &&
//                            workItem.getSprintId() == sprintDaoService.getSprintIdFromName(sprint) &&
//                            workItem.getStatusCode() == WorkItemStatus.COMPLETED
//            ).toList());
            workItemList.addAll(workItemRepository.findByAssigneeIdAndSprintIdAndStatusCode(assigneeId, sprintId, WorkItemStatus.COMPLETED));
        }
        return workItemList;
    }

    public List<WorkItem> getTasksForFilters(String sprint, boolean newFilter,
                                             boolean ongoingFilter, boolean completedFilter) {
        List<WorkItem> workItemList = new ArrayList<>();
        long sprintId = sprintDaoService.getSprintIdFromName(sprint);
        if (newFilter) {
//            workItemList.addAll(workItems.stream().filter(
//                    workItem -> workItem.getSprintId() == sprintDaoService.getSprintIdFromName(sprint) &&
//                                workItem.getStatusCode() == WorkItemStatus.NEW
//            ).toList());
            workItemList.addAll(workItemRepository.findBySprintIdAndStatusCode(sprintId, WorkItemStatus.NEW));
        }
        if (ongoingFilter) {
//            workItemList.addAll(workItems.stream().filter(
//                    workItem -> workItem.getSprintId() == sprintDaoService.getSprintIdFromName(sprint) &&
//                                workItem.getStatusCode() == WorkItemStatus.ONGOING
//            ).toList());
            workItemList.addAll(workItemRepository.findBySprintIdAndStatusCode(sprintId, WorkItemStatus.ONGOING));
        }
        if (completedFilter) {
//            workItemList.addAll(workItems.stream().filter(
//                    workItem -> workItem.getSprintId() == sprintDaoService.getSprintIdFromName(sprint) &&
//                                workItem.getStatusCode() == WorkItemStatus.COMPLETED
//            ).toList());
            workItemList.addAll(workItemRepository.findBySprintIdAndStatusCode(sprintId, WorkItemStatus.COMPLETED));
        }
        return workItemList;
    }

    public WorkItem getWorkItemForId(long workItemId){
        return workItemRepository.findByWorkItemId(workItemId);
//        return workItems.stream().filter(workItem -> workItem.getWorkItemId()==workItemId).findAny().get();
    }

    public void deleteWorkItem(long workItemId) {
        workItemRepository.deleteByWorkItemId(workItemId);
//        workItems.removeIf(workItem -> workItem.getWorkItemId() == workItemId);
    }

    public void updateWorkItem(long workItemId, String newStatus) {
//        WorkItem workItemToUpdate = workItems.stream()
//                .filter(workItem -> workItem.getWorkItemId() == workItemId)
//                .findAny().get();
        WorkItem workItemToUpdate = workItemRepository.findByWorkItemId(workItemId);
        deleteWorkItem(workItemId);
        workItemToUpdate.setStatus(newStatus.toUpperCase());
        workItemToUpdate.setStatusCode(workItemStatus.getStatusCode(newStatus));
        addWorkItem(workItemToUpdate, false);
    }

    public void updateWorkItem(int workItemId, WorkItem workItemPatch) {
//        WorkItem workItemToUpdate = workItems.stream()
//                .filter(workItem -> workItem.getWorkItemId().equals(workItemId))
//                .findAny().get();
        WorkItem workItemToUpdate = workItemRepository.findByWorkItemId(workItemId);
        workItemPatch.setWorkItemId(workItemToUpdate.getWorkItemId());
        workItemPatch.setSprintId(sprintDaoService.getSprintIdFromName(workItemPatch.getSprint()));
        workItemPatch.setStatusCode(workItemStatus.getStatusCode(workItemPatch.getStatus()));
        workItemPatch.setPriorityCode(workItemPriority.getPriorityCode(workItemPatch.getPriority()));
        workItemPatch.setAssigneeId(userDaoService.getUserIdFromName(workItemPatch.getAssigneeName()));
        workItemPatch.setCreatorId(workItemToUpdate.getCreatorId());
        workItemPatch.setCreatorName(workItemToUpdate.getCreatorName());
        workItemPatch.setCreationDate(workItemToUpdate.getCreationDate());
        deleteWorkItem(workItemToUpdate.getWorkItemId());
        addWorkItem(workItemPatch, false);
    }

    public void updateWorkItemSprintName(long workItemId, String newSprintName) {
//        WorkItem workItemToUpdate = workItems.stream()
//                .filter(workItem -> workItem.getWorkItemId() == workItemId)
//                .findAny().get();
        WorkItem workItemToUpdate = workItemRepository.findByWorkItemId(workItemId);
        deleteWorkItem(workItemId);
        workItemToUpdate.setSprint(newSprintName);
        addWorkItem(workItemToUpdate, false);
    }

    public long countWorkItems(String userName, int sprintId, String status){
        long assigneeId = userDaoService.getUserIdFromName(userName);
        int statusCode = workItemStatus.getStatusCode(status);
        return workItemRepository.countByAssigneeIdAndSprintIdAndStatusCode(assigneeId, sprintId, statusCode);
//        return workItems.stream().
//                filter(
//                        workItem ->
//                                workItem.getAssigneeId()== userDaoService.getUserIdFromName(userName) &&
//                                workItem.getSprintId()==sprintId &&
//                                workItem.getStatusCode()==workItemStatus.getStatusCode(status)
//                ).count();
    }

    public long countWorkItems(String userName, String status){
        long assigneeId = userDaoService.getUserIdFromName(userName);
        int statusCode = workItemStatus.getStatusCode(status);
        return workItemRepository.countByAssigneeIdAndStatusCode(assigneeId, statusCode);
//        return workItems.stream()
//                .filter(
//                        workItem ->
//                                workItem.getAssigneeId()== userDaoService.getUserIdFromName(userName) &&
//                                workItem.getStatusCode()==workItemStatus.getStatusCode(status)
//                ).count();
    }
}
