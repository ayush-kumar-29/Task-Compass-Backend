package workcompass.backend.sprint;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "sprints_table")
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sprintId;
    private String sprintName;
    private LocalDate sprintStartDate;
    private LocalDate sprintEndDate;
    private String status;
    private Integer statusCode;
    private Boolean isDeleted;

    public Sprint() {
    }

    public Sprint(Long id, String sprintId, String sprintName, LocalDate sprintStartDate,
                  LocalDate sprintEndDate, String status, Integer statusCode, Boolean isDeleted) {
        this.id=id;
        this.sprintId = sprintId;
        this.sprintName = sprintName;
        this.sprintStartDate = sprintStartDate;
        this.sprintEndDate = sprintEndDate;
        this.status = status;
        this.statusCode = statusCode;
        this.isDeleted=isDeleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSprintId() {
        return sprintId;
    }

    public void setSprintId(String sprintId) {
        this.sprintId = sprintId;
    }

    public String getSprintName() {
        return sprintName;
    }

    public void setSprintName(String sprintName) {
        this.sprintName = sprintName;
    }

    public LocalDate getSprintStartDate() {
        return sprintStartDate;
    }

    public void setSprintStartDate(LocalDate sprintStartDate) {
        this.sprintStartDate = sprintStartDate;
    }

    public LocalDate getSprintEndDate() {
        return sprintEndDate;
    }

    public void setSprintEndDate(LocalDate sprintEndDate) {
        this.sprintEndDate = sprintEndDate;
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

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "Sprint{" +
                "id=" + id +
                ", sprintId='" + sprintId + '\'' +
                ", sprintName='" + sprintName + '\'' +
                ", sprintStartDate=" + sprintStartDate +
                ", sprintEndDate=" + sprintEndDate +
                ", status='" + status + '\'' +
                ", statusCode=" + statusCode +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
