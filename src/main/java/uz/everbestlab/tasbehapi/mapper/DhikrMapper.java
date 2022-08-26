package uz.everbestlab.tasbehapi.mapper;

import org.mapstruct.Mapper;
import uz.everbestlab.tasbehapi.dto.DhikrDto;
import uz.everbestlab.tasbehapi.entity.Dhikr;

@Mapper(componentModel = "spring")
public interface DhikrMapper extends EntityMapper<Dhikr, DhikrDto> {

}
