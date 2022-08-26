package uz.everbestlab.tasbehapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import uz.everbestlab.tasbehapi.dto.TaskDto;
import uz.everbestlab.tasbehapi.dto.UserTasksDto;
import uz.everbestlab.tasbehapi.entity.User;
import uz.everbestlab.tasbehapi.entity.UserTasks;
import uz.everbestlab.tasbehapi.repository.UserTasksRepository;
import uz.everbestlab.tasbehapi.security.UserUtil;
import uz.everbestlab.tasbehapi.service.UserTasksService;
import uz.everbestlab.tasbehapi.service.mapper.UserTasksMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserTasksServiceImpl implements UserTasksService {

    private final UserTasksRepository userTasksRepository;
    private final UserTasksMapper userTasksMapper;

    @Override
    public UserTasks join(Long userId, Long taskId) {

        Optional<UserTasks> optional = userTasksRepository
                .findByUserIdEqualsAndTaskIdEquals(userId, taskId);

        if (optional.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User has already joined to th task");
        }

        UserTasks userTasks = new UserTasks();
        userTasks.setUserId(userId);
        userTasks.setTaskId(taskId);
        userTasks.setCount(0L);
        return userTasksRepository.save(userTasks);
    }

    @Override
    public void deleteByUserAndTask(Long userId, Long taskId) {
        UserTasks userTasks = getByUserAndTask(userId, taskId);
        userTasksRepository.delete(userTasks);
    }

    @Override
    public UserTasksDto updateCount(Long taskId, UserTasksDto dto) {
        User user = UserUtil.currentUser();
        UserTasks userTasks = getByUserAndTask(user.getId(), taskId);
        if (dto.getCount() != null && dto.getCount() > userTasks.getCount()){
            userTasks.setCount(dto.getCount());
            userTasksRepository.save(userTasks);
        }
        return userTasksMapper.toDto(userTasks);
    }

    @Override
    public UserTasks getByUserAndTask(Long userId, Long taskId) {
        return userTasksRepository.findByUserIdEqualsAndTaskIdEquals(userId, taskId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "User has not joined to the task"
                ));
    }

    @Override
    public List<UserTasks> getByTaskId(Long taskId) {
        return userTasksRepository.findByTaskIdEquals(taskId);
    }

}
