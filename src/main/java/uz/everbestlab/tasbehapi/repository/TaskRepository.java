package uz.everbestlab.tasbehapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.everbestlab.tasbehapi.dto.TaskListDto;
import uz.everbestlab.tasbehapi.entity.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "SELECT new uz.everbestlab.tasbehapi.dto.TaskListDto(\n" +
            " t.task.id AS id, \n" +
            " t.task.dhikr.transliteration AS transliteration, \n" +
            " t.task.dhikr.translation AS translation, \n" +
            " t.task.taskCount AS taskCount, \n" +
            " (SELECT count(ut) FROM UserTasks ut WHERE ut.taskId = t.id) AS memberCount, \n" +
            " t.task.isNonStop AS isNonStop, \n" +
            " t.task.startTime AS startTime, \n" +
            " t.task.endTime AS endTime, \n" +
            " CASE WHEN ?1 = t.task.createdBy THEN true ELSE false END AS createdByMe, \n" +
            " t.task.createdByUser.firstName AS inviterName \n" +
            " ) FROM UserTasks t WHERE t.userId = ?1 AND t.task.endTime > current_timestamp \n")
    List<TaskListDto> getUserTasks(Long userId);

}
