package uz.everbestlab.tasbehapi.service;

import uz.everbestlab.tasbehapi.dto.UserTasksDto;
import uz.everbestlab.tasbehapi.entity.UserTasks;

import java.util.List;

public interface UserTasksService {

    UserTasks join(Long userId, Long taskId);

    void deleteByUserAndTask(Long userId, Long taskId);

    UserTasksDto updateCount(Long taskId, UserTasksDto dto);

    UserTasks getByUserAndTask(Long userId, Long taskId);

    List<UserTasks> getByTaskId(Long taskId);

}
