package uz.everbestlab.tasbehapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.everbestlab.tasbehapi.dto.TaskDto;
import uz.everbestlab.tasbehapi.dto.TaskListDto;
import uz.everbestlab.tasbehapi.dto.UserDto;
import uz.everbestlab.tasbehapi.dto.UserTasksDto;
import uz.everbestlab.tasbehapi.entity.UserTasks;
import uz.everbestlab.tasbehapi.service.TaskService;
import uz.everbestlab.tasbehapi.service.UserTasksService;

import java.util.List;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto dto){
        return ResponseEntity.ok(taskService.createTask(dto));
    }

    @PostMapping("/join/{taskId}")
    public ResponseEntity<TaskDto> joinToTask(@PathVariable Long taskId){
        return ResponseEntity.ok(taskService.joinToTask(taskId));
    }

    @PutMapping("/count/{taskId}")
    public ResponseEntity<UserTasksDto> updateCount(@PathVariable Long taskId, @RequestBody UserTasksDto taskDto){
        return ResponseEntity.ok(taskService.updateCount(taskId, taskDto));
    }

    @GetMapping("/users/{taskId}")
    public ResponseEntity<List<UserDto>> getAllMembers(@PathVariable("taskId") Long id){
        return ResponseEntity.ok(taskService.getAllMembers(id));
    }

    @GetMapping
    public ResponseEntity<List<TaskListDto>> getMyTasks(){
        return ResponseEntity.ok(taskService.getMyTasks());
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable("taskId") Long id){
        taskService.deleteByTaskId(id);
    }

}
