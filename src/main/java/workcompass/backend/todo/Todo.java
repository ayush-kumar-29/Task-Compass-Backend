package workcompass.backend.todo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "todos_table")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String todoId;
    private String userId;
    private String todoDescription;
    private LocalDate dueDate;
    private Boolean isDone;
    private LocalDate completionDate;
    private Boolean isDeleted;

    public Todo() {}

    public Todo(Long id, String todoId, String userId, String todoDescription, LocalDate dueDate,
                Boolean isDone, LocalDate completionDate, Boolean isDeleted) {
        this.id=id;
        this.todoId = todoId;
        this.userId = userId;
        this.todoDescription = todoDescription;
        this.dueDate = dueDate;
        this.isDone = isDone;
        this.completionDate = completionDate;
        this.isDeleted = isDeleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTodoId() {
        return todoId;
    }

    public void setTodoId(String todoId) {
        this.todoId = todoId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTodoDescription() {
        return todoDescription;
    }

    public void setTodoDescription(String todoDescription) {
        this.todoDescription = todoDescription;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", todoId='" + todoId + '\'' +
                ", userId=" + userId +
                ", todoDescription='" + todoDescription + '\'' +
                ", dueDate=" + dueDate +
                ", isDone=" + isDone +
                ", completionDate=" + completionDate +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
