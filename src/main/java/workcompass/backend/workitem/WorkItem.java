package workcompass.backend.workitem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "work_items_table")
public class WorkItem {
    @Id
    @GeneratedValue
    private Long workItemId;
    private String workItemTitle;
    private String workItemDescription;
    private String sprint;
    private Long sprintId;
    private LocalDate dueDate;
    private String status;
    private Integer statusCode;
    private String priority;
    private Integer priorityCode;
    private String assigneeName;
    private Long assigneeId;
    private String creatorName;
    private Long creatorId;
    private LocalDate creationDate;

    public WorkItem(Long workItemId, String workItemTitle, String workItemDescription, String sprint,
                    Long sprintId, LocalDate dueDate, String status, Integer statusCode,
                    String priority, Integer priorityCode, String assigneeName, Long assigneeId,
                    String creatorName, Long creatorId, LocalDate creationDate) {
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

    public Long getWorkItemId() {
        return workItemId;
    }

    public void setWorkItemId(Long workItemId) {
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

    public Long getSprintId() {
        return sprintId;
    }

    public void setSprintId(Long sprintId) {
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

    public Long getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(Long assigneeId) {
        this.assigneeId = assigneeId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
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
