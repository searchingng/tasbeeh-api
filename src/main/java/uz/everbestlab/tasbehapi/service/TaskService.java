package uz.everbestlab.tasbehapi.service;

import uz.everbestlab.tasbehapi.dto.TaskDto;
import uz.everbestlab.tasbehapi.dto.TaskListDto;
import uz.everbestlab.tasbehapi.dto.UserDto;
import uz.everbestlab.tasbehapi.dto.UserTasksDto;

import java.util.List;

public interface TaskService {

    TaskListDto createTask(TaskDto dto);

    List<TaskListDto> getTasksByUserId(Long userId);

    List<TaskListDto> getMyTasks();

    TaskListDto joinToTask(Long id);

    UserTasksDto updateCount(Long taskId, UserTasksDto taskDto);

    List<UserDto> getAllMembers(Long id);

    void deleteByTaskId(Long id);

    TaskListDto getTaskById(Long taskId, Long userId);
}
