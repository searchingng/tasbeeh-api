package uz.everbestlab.tasbehapi.service;

import uz.everbestlab.tasbehapi.dto.DhikrDto;

public interface DhikrService {

    DhikrDto addDhikr(DhikrDto dto);

    void deleteById(Long id);

}
