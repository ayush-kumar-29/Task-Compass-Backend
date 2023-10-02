package workcompass.backend.sprint;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "sprints_table")
public class Sprint {
    @Id
    @GeneratedValue
    private Long sprintId;
    private String sprintName;
    private LocalDate sprintStartDate;
    private LocalDate sprintEndDate;
    private String status;
    private Integer statusCode;

    public Sprint(Long sprintId, String sprintName, LocalDate sprintStartDate,
                  LocalDate sprintEndDate, String status, Integer statusCode) {
        this.sprintId = sprintId;
        this.sprintName = sprintName;
        this.sprintStartDate = sprintStartDate;
        this.sprintEndDate = sprintEndDate;
        this.status = status;
        this.statusCode = statusCode;
    }

    public Long getSprintId() {
        return sprintId;
    }

    public void setSprintId(Long sprintId) {
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

    @Override
    public String toString() {
        return "Sprint{" +
                "sprintId=" + sprintId +
                ", sprintName='" + sprintName + '\'' +
                ", sprintStartDate=" + sprintStartDate +
                ", sprintEndDate=" + sprintEndDate +
                ", status='" + status + '\'' +
                ", statusCode=" + statusCode +
                '}';
    }
}
