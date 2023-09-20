package workcompass.backend.todo;

import java.time.LocalDate;

public class Todo {
    private Integer todoId;
    private Integer userId;
    private String todoDescription;
    private LocalDate dueDate;
    private Boolean isDone;
    private LocalDate completionDate;

    public Todo(Integer todoId, Integer userId, String todoDescription, LocalDate dueDate, Boolean isDone, LocalDate completionDate) {
        this.todoId = todoId;
        this.userId = userId;
        this.todoDescription = todoDescription;
        this.dueDate = dueDate;
        this.isDone = isDone;
        this.completionDate = completionDate;
    }

    public Integer getTodoId() {
        return todoId;
    }

    public void setTodoId(Integer todoId) {
        this.todoId = todoId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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

    @Override
    public String toString() {
        return "Todo{" +
                "todoId=" + todoId +
                ", userId=" + userId +
                ", todoDescription='" + todoDescription + '\'' +
                ", dueDate=" + dueDate +
                ", isDone=" + isDone +
                ", completionDate=" + completionDate +
                '}';
    }
}
