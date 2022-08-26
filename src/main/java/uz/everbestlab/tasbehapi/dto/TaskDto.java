package uz.everbestlab.tasbehapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.everbestlab.tasbehapi.entity.enums.TaskStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private Long id;
    private Long dhikrId;
    private Long taskCount;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean isNonStop;
    private TaskStatus status;
    private Long createdBy;

}
