package workcompass.backend.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUserIdAndIsDoneAndIsDeleted(String userId, boolean isDone,
                                                 boolean isDeleted);
    Todo findByUserIdAndTodoId(String userId, String todoId);
//    @Query("DELETE FROM Todo t WHERE t.userId=:userId AND  t.todoId=:todoId")
//    void deleteByUserIdAndTodoId(@Param("userId") Long userId, @Param("todoId")String todoId);
    Long countByUserIdAndIsDoneAndIsDeleted(String userId, boolean isDone, boolean isDeleted);
    @Query("SELECT COUNT(*) FROM Todo")
    Long getRowCount();
}
