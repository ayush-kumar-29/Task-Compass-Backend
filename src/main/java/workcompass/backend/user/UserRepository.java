package workcompass.backend.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    @Query("SELECT u.userId FROM User u WHERE u.userName = :userName")
    Long findUserIdByUserName(@Param("userName") String userName);
    @Query("SELECT DISTINCT u.userName FROM User u")
    List<String> findDistinctUserName();
}
