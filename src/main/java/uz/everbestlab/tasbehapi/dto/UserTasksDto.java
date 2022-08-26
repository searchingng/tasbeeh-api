package uz.everbestlab.tasbehapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.everbestlab.tasbehapi.entity.enums.TaskStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTasksDto {

    private Long id;

    private Long userId;

    private Long taskId;

    private Long count;

}
