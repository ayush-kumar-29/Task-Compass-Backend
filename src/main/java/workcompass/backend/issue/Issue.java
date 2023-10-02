package workcompass.backend.issue;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.time.LocalDate;

@Entity
@Table(name = "issues_table")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String issueId;
    private String issueTitle;
    private String issueDescription;
    private LocalDate dueDate;
    private Integer statusCode;
    private String status;
    private Integer severityCode;
    private String severity;
    private String assigneeName;
    private Long assigneeId;
    private String creatorName;
    private Long creatorId;
    private LocalDate creationDate;
    private Boolean isDeleted;

    public Issue() {
    }

    public Issue(Long id, String issueId, String issueTitle, String issueDescription, LocalDate dueDate,
                 String status, Integer statusCode, String severity, Integer severityCode,
                 String assigneeName, Long assigneeId, String creatorName, Long creatorId,
                 LocalDate creationDate) {
        this.id=id;
        this.issueId = issueId;
        this.issueTitle = issueTitle;
        this.issueDescription = issueDescription;
        this.dueDate = dueDate;
        this.statusCode = statusCode;
        this.status = status;
        this.severityCode = severityCode;
        this.severity = severity;
        this.assigneeId = assigneeId;
        this.assigneeName = assigneeName;
        this.creatorId = creatorId;
        this.creatorName = creatorName;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getIssueTitle() {
        return issueTitle;
    }

    public void setIssueTitle(String issueTitle) {
        this.issueTitle = issueTitle;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSeverityCode() {
        return severityCode;
    }

    public void setSeverityCode(Integer severityCode) {
        this.severityCode = severityCode;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Long getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(Long assigneeId) {
        this.assigneeId = assigneeId;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
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
        return "Issue{" +
                "id=" + id +
                ", issueId='" + issueId + '\'' +
                ", issueTitle='" + issueTitle + '\'' +
                ", issueDescription='" + issueDescription + '\'' +
                ", dueDate=" + dueDate +
                ", statusCode=" + statusCode +
                ", status='" + status + '\'' +
                ", severityCode=" + severityCode +
                ", severity='" + severity + '\'' +
                ", assigneeName='" + assigneeName + '\'' +
                ", assigneeId=" + assigneeId +
                ", creatorName='" + creatorName + '\'' +
                ", creatorId=" + creatorId +
                ", creationDate=" + creationDate +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
