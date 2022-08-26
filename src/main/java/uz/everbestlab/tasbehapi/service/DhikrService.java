package uz.everbestlab.tasbehapi.service;

import uz.everbestlab.tasbehapi.dto.DhikrDto;

import java.util.List;

public interface DhikrService {

    DhikrDto addDhikr(DhikrDto dto);

    void deleteById(Long id);

    List<DhikrDto> getAll();

}
