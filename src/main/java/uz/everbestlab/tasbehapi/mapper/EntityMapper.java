package uz.everbestlab.tasbehapi.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import uz.everbestlab.tasbehapi.dto.UserDto;

import java.util.List;

public interface EntityMapper<E, D> {

    D toDto(E entity);

    E toEntity(UserDto dto);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);


}
