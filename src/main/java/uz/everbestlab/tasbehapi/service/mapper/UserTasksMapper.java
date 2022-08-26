package uz.everbestlab.tasbehapi.service.mapper;

import org.mapstruct.Mapper;
import uz.everbestlab.tasbehapi.dto.UserTasksDto;
import uz.everbestlab.tasbehapi.entity.UserTasks;

@Mapper(componentModel = "spring")
public interface UserTasksMapper extends EntityMapper<UserTasks, UserTasksDto>{
}
