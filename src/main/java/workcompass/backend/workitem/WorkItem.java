package workcompass.backend.workitem;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "work_items_table")
public class WorkItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String workItemId;
    private String workItemTitle;
    private String workItemDescription;
    private String sprint;
    private String sprintId;
    private LocalDate dueDate;
    private String status;
    private Integer statusCode;
    private String priority;
    private Integer priorityCode;
    private String assigneeName;
    private String assigneeId;
    private String creatorName;
    private String creatorId;
    private LocalDate creationDate;
    private Boolean isDeleted;

    public WorkItem() {
    }

    public WorkItem(Long id, String workItemId, String workItemTitle, String workItemDescription, String sprint,
                    String sprintId, LocalDate dueDate, String status, Integer statusCode,
                    String priority, Integer priorityCode, String assigneeName, String assigneeId,
                    String creatorName, String creatorId, LocalDate creationDate, Boolean isDeleted) {
        this.id=id;
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
        this.isDeleted=isDeleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkItemId() {
        return workItemId;
    }

    public void setWorkItemId(String workItemId) {
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

    public String getSprintId() {
        return sprintId;
    }

    public void setSprintId(String sprintId) {
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

    public String getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "WorkItem{" +
                "id=" + id +
                ", workItemId='" + workItemId + '\'' +
                ", workItemTitle='" + workItemTitle + '\'' +
                ", workItemDescription='" + workItemDescription + '\'' +
                ", sprint='" + sprint + '\'' +
                ", sprintId='" + sprintId + '\'' +
                ", dueDate=" + dueDate +
                ", status='" + status + '\'' +
                ", statusCode=" + statusCode +
                ", priority='" + priority + '\'' +
                ", priorityCode=" + priorityCode +
                ", assigneeName='" + assigneeName + '\'' +
                ", assigneeId='" + assigneeId + '\'' +
                ", creatorName='" + creatorName + '\'' +
                ", creatorId='" + creatorId + '\'' +
                ", creationDate=" + creationDate +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
