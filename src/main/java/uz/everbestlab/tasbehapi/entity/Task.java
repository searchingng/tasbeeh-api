package uz.everbestlab.tasbehapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.everbestlab.tasbehapi.entity.enums.TaskStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "dhikr_id", insertable = false, updatable = false)
    private Dhikr dhikr;

    @Column(name = "dhikr_id")
    private Long dhikrId;

    private Long taskCount;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Boolean isNonStop;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @ManyToOne
    @JoinColumn(name = "created_by_id", updatable = false, insertable = false)
    private User createdByUser;

    @Column(name = "created_by_id")
    private Long createdBy;

}
