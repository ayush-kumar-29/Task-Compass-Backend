package workcompass.backend.workitem;

import org.hibernate.jdbc.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkItemRepository extends JpaRepository<WorkItem, Long> {
    List<WorkItem> findByAssigneeIdAndSprintIdAndStatusCodeAndIsDeleted(
            String assigneeId, String sprintId, int statusCode, boolean isDeleted);
    List<WorkItem> findBySprintIdAndStatusCodeAndIsDeleted(String sprintId, int statusCode, boolean isDeleted);
    WorkItem findByWorkItemId(String workItemId);
    void deleteByWorkItemId(String workItemId);
    Long countByAssigneeIdAndSprintIdAndStatusCode(String assigneeId, String sprintId, int statusCode);
    Long countByAssigneeIdAndStatusCode(String assigneeId, int statusCode);
    @Query("SELECT COUNT(*) FROM WorkItem")
    Long getRowCount();
}
