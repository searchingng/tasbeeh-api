package uz.everbestlab.tasbehapi.service.mapper;

import org.mapstruct.Mapper;
import uz.everbestlab.tasbehapi.dto.TaskDto;
import uz.everbestlab.tasbehapi.entity.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper extends EntityMapper<Task, TaskDto> {
}
