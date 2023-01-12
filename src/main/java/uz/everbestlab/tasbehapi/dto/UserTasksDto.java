package uz.everbestlab.tasbehapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTasksDto {

    private Long id;

    private Long userId;

    private Long taskId;

    private Long count;

}
