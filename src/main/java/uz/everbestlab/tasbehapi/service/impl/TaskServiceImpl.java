package uz.everbestlab.tasbehapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import uz.everbestlab.tasbehapi.dto.TaskDto;
import uz.everbestlab.tasbehapi.dto.TaskListDto;
import uz.everbestlab.tasbehapi.dto.UserDto;
import uz.everbestlab.tasbehapi.dto.UserTasksDto;
import uz.everbestlab.tasbehapi.entity.Task;
import uz.everbestlab.tasbehapi.entity.User;
import uz.everbestlab.tasbehapi.entity.enums.TaskStatus;
import uz.everbestlab.tasbehapi.repository.TaskRepository;
import uz.everbestlab.tasbehapi.security.UserUtil;
import uz.everbestlab.tasbehapi.service.TaskService;
import uz.everbestlab.tasbehapi.service.UserTasksService;
import uz.everbestlab.tasbehapi.service.mapper.TaskMapper;
import uz.everbestlab.tasbehapi.service.mapper.UserMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserTasksService userTasksService;
    private final TaskMapper taskMapper;
    private final UserMapper userMapper;

    @Override
    public TaskListDto createTask(TaskDto dto) {
        User user = UserUtil.currentUser();
        Task task = taskMapper.toEntity(dto);
        task.setStatus(TaskStatus.ACTIVE);
        task.setCreatedBy(user.getId());

        taskRepository.save(task);

        userTasksService.join(user.getId(), task.getId());
        return getTaskById(task.getId(), user.getId());
//        return taskMapper.toDto(task);
    }

    @Override
    public List<TaskListDto> getTasksByUserId(Long userId) {
        return taskRepository.getUserTasks(userId);
    }

    @Override
    public List<TaskListDto> getMyTasks() {
        User user = UserUtil.currentUser();
        return getTasksByUserId(user.getId());
    }

    @Override
    public TaskListDto getTaskById(Long taskId, Long userId) {
        return taskRepository.getByTaskIdAndUserId(userId, taskId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Task Not Found"));
    }

    @Override
    public TaskListDto joinToTask(Long id) {
        User user = UserUtil.currentUser();

        if (!taskRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Such Task not found!");

        userTasksService.join(user.getId(), id);
//        return taskMapper.toDto(taskRepository.findById(id).get());
        return getTaskById(id, user.getId());
    }

    @Override
    public UserTasksDto updateCount(Long taskId, UserTasksDto taskDto) {
        return userTasksService.updateCount(taskId, taskDto);
    }

    @Override
    public List<UserDto> getAllMembers(Long id) {
        return userTasksService.getByTaskId(id).stream()
                .map(ut -> userMapper.toDto(ut.getUser()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteByTaskId(Long id) {
        User user = UserUtil.currentUser();
        userTasksService.deleteByUserAndTask(user.getId(), id);
    }
}
