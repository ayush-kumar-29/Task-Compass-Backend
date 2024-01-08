package workcompass.backend.sprint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SprintRepository extends JpaRepository<Sprint, Long> {
    Sprint findBySprintId(String sprintId);
    @Query("SELECT DISTINCT s.sprintName FROM Sprint s WHERE s.isDeleted=FALSE")
    List<String> findDistinctSprintName();
    List<Sprint> findByStatusCodeAndIsDeleted(int statusCode, boolean isDeleted);
    @Query("SELECT s.sprintId FROM Sprint s WHERE s.sprintName = :sprintName")
    String findSprintIdBySprintName(@Param("sprintName") String sprintName);
//    void deleteBySprintId(long sprintId);
    @Query("SELECT COUNT(*) FROM Sprint")
    Long getRowCount();
}
