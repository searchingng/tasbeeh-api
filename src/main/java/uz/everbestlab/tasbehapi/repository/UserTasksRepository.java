package uz.everbestlab.tasbehapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.everbestlab.tasbehapi.entity.UserTasks;

import java.util.List;
import java.util.Optional;

public interface UserTasksRepository extends JpaRepository<UserTasks, Long> {

    Optional<UserTasks> findByUserIdEqualsAndTaskIdEquals(Long userId, Long taskId);

    @Query(value = "SELECT u FROM UserTasks u \n" +
            "WHERE u.userId = ?1 AND u.task.endTime > current_timestamp ")
    List<UserTasks> findByUserIdEquals(Long userId);

    @Query(value = "SELECT u FROM UserTasks u \n" +
            "WHERE u.taskId = ?1")
    List<UserTasks> findByTaskIdEquals(Long taskId);

}
