package uz.everbestlab.tasbehapi.service;

import uz.everbestlab.tasbehapi.dto.TaskDto;
import uz.everbestlab.tasbehapi.dto.TaskListDto;
import uz.everbestlab.tasbehapi.dto.UserDto;
import uz.everbestlab.tasbehapi.dto.UserTasksDto;

import java.util.List;

public interface TaskService {

    TaskDto createTask(TaskDto dto);

    List<TaskListDto> getTasksByUserId(Long userId);

    List<TaskListDto> getMyTasks();

    TaskDto joinToTask(Long id);

    UserTasksDto updateCount(Long taskId, UserTasksDto taskDto);

    List<UserDto> getAllMembers(Long id);

    void deleteByTaskId(Long id);
}
