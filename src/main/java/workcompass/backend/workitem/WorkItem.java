package workcompass.backend.workitem;

import java.time.LocalDate;

public class WorkItem {
    private Integer workItemId;
    private String workItemTitle;
    private String workItemDescription;
    private String sprint;
    private Integer sprintId;
    private LocalDate dueDate;
    private String status;
    private Integer statusCode;
    private String priority;
    private Integer priorityCode;
    private String assigneeName;
    private Integer assigneeId;
    private String creatorName;
    private Integer creatorId;
    private LocalDate creationDate;

    public WorkItem(Integer workItemId, String workItemTitle, String workItemDescription, String sprint,
                    Integer sprintId, LocalDate dueDate, String status, Integer statusCode,
                    String priority, Integer priorityCode, String assigneeName, Integer assigneeId,
                    String creatorName, Integer creatorId, LocalDate creationDate) {
        this.workItemId = workItemId;
        this.workItemTitle = workItemTitle;
        this.workItemDescription = workItemDescription;
        this.sprint = sprint;
        this.sprintId = sprintId;
        this.dueDate = dueDate;
        this.status = status;
        this.statusCode = statusCode;
        this.priority = priority;
        this.priorityCode = priorityCode;
        this.assigneeName = assigneeName;
        this.assigneeId = assigneeId;
        this.creatorName = creatorName;
        this.creatorId = creatorId;
        this.creationDate = creationDate;
    }

    public Integer getWorkItemId() {
        return workItemId;
    }

    public void setWorkItemId(Integer workItemId) {
        this.workItemId = workItemId;
    }

    public String getWorkItemTitle() {
        return workItemTitle;
    }

    public void setWorkItemTitle(String workItemTitle) {
        this.workItemTitle = workItemTitle;
    }

    public String getWorkItemDescription() {
        return workItemDescription;
    }

    public void setWorkItemDescription(String workItemDescription) {
        this.workItemDescription = workItemDescription;
    }

    public String getSprint() {
        return sprint;
    }

    public void setSprint(String sprint) {
        this.sprint = sprint;
    }

    public Integer getSprintId() {
        return sprintId;
    }

    public void setSprintId(Integer sprintId) {
        this.sprintId = sprintId;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Integer getPriorityCode() {
        return priorityCode;
    }

    public void setPriorityCode(Integer priorityCode) {
        this.priorityCode = priorityCode;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
    }

    public Integer getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(Integer assigneeId) {
        this.assigneeId = assigneeId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "WorkItem{" +
                "taskId=" + workItemId +
                ", taskTitle='" + workItemTitle + '\'' +
                ", taskDescription='" + workItemDescription + '\'' +
                ", sprint='" + sprint + '\'' +
                ", sprintId=" + sprintId +
                ", dueDate=" + dueDate +
                ", status='" + status + '\'' +
                ", statusCode=" + statusCode +
                ", priority='" + priority + '\'' +
                ", priorityCode=" + priorityCode +
                ", assigneeName='" + assigneeName + '\'' +
                ", assigneeId=" + assigneeId +
                ", creatorName='" + creatorName + '\'' +
                ", creatorId=" + creatorId +
                ", creationDate=" + creationDate +
                '}';
    }
}
