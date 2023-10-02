package workcompass.backend.workitem;

import org.hibernate.jdbc.Work;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkItemRepository extends JpaRepository<WorkItem, Long> {
    List<WorkItem> findByAssigneeIdAndSprintIdAndStatusCode(long assigneeId, long sprintId, int statusCode);
    List<WorkItem> findBySprintIdAndStatusCode(long sprintId, int statusCode);
    WorkItem findByWorkItemId(long workItemId);
    void deleteByWorkItemId(long workItemId);
    Long countByAssigneeIdAndSprintIdAndStatusCode(long assigneeId, long sprintId, int statusCode);
    Long countByAssigneeIdAndStatusCode(long assigneeId, int statusCode);
}
