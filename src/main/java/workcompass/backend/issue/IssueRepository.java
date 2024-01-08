package workcompass.backend.issue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import workcompass.backend.todo.Todo;

import java.util.List;

public interface IssueRepository extends JpaRepository<Issue, Long> {
    List<Issue> findByAssigneeIdAndStatusCodeAndIsDeleted(String assigneeId, int statusCode, boolean isDeleted);
    Issue findByIssueId(String issueId);
//    void deleteByIssueId(long issueId);
    Long countByAssigneeIdAndStatusCodeAndIsDeleted(String assigneeId, int statusCode, boolean isDeleted);
    @Query("SELECT COUNT(*) FROM Issue")
    Long getRowCount();

}
