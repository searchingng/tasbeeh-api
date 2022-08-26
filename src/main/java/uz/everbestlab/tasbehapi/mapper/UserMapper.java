package uz.everbestlab.tasbehapi.mapper;

import org.mapstruct.Mapper;
import uz.everbestlab.tasbehapi.dto.UserDto;
import uz.everbestlab.tasbehapi.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<User, UserDto>{
}
