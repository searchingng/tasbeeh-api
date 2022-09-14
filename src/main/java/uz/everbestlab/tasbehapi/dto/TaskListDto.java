package uz.everbestlab.tasbehapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskListDto {

    private Long id;
    private Long dhikrId;
    private String transliteration;
    private String translation;
    private Long taskCount;
    private Long memberCount;
    private Boolean isNonStop;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean createdByMe;
    private String inviterName;

}
