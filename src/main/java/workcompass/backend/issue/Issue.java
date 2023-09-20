package workcompass.backend.issue;

import java.time.LocalDate;

public class Issue {
    private Integer issueId;
    private String issueTitle;
    private String issueDescription;
    private LocalDate dueDate;
    private Integer statusCode;
    private String status;
    private Integer severityCode;
    private String severity;
    private String assigneeName;
    private Integer assigneeId;
    private String creatorName;
    private Integer creatorId;
    private LocalDate creationDate;

    public Issue(Integer issueId, String issueTitle, String issueDescription, LocalDate dueDate,
                 String status, Integer statusCode, String severity, Integer severityCode,
                 String assigneeName, Integer assigneeId, String creatorName, Integer creatorId,
                 LocalDate creationDate) {
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

    public Integer getIssueId() {
        return issueId;
    }

    public void setIssueId(Integer issueId) {
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

    public Integer getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(Integer assigneeId) {
        this.assigneeId = assigneeId;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
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

    @Override
    public String toString() {
        return "Issue{" +
                "issueId=" + issueId +
                ", issueTitle='" + issueTitle + '\'' +
                ", issueDescription='" + issueDescription + '\'' +
                ", dueDate=" + dueDate +
                ", statusCode=" + statusCode +
                ", status='" + status + '\'' +
                ", severityCode=" + severityCode +
                ", severity='" + severity + '\'' +
                ", assigneeId=" + assigneeId +
                ", assigneeName='" + assigneeName + '\'' +
                ", creatorId=" + creatorId +
                ", creatorName='" + creatorName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
