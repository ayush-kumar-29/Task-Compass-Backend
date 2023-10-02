package workcompass.backend.sprint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SprintRepository extends JpaRepository<Sprint, Long> {
    Sprint findBySprintId(long sprintId);
    @Query("SELECT DISTINCT s.sprintName FROM Sprint s")
    List<String> findDistinctSprintName();
    List<Sprint> findByStatusCode(int statusCode);
    Long findSprintIdBySprintName(String sprintName);
    void deleteBySprintId(long sprintId);
}
