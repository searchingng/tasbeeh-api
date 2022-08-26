package uz.everbestlab.tasbehapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.everbestlab.tasbehapi.dto.DhikrDto;
import uz.everbestlab.tasbehapi.entity.Dhikr;
import uz.everbestlab.tasbehapi.mapper.DhikrMapper;
import uz.everbestlab.tasbehapi.repository.DhikrRepository;
import uz.everbestlab.tasbehapi.service.DhikrService;

@Service
@RequiredArgsConstructor
public class DhikrServiceImpl implements DhikrService {

    private final DhikrRepository dhikrRepository;
    private final DhikrMapper dhikrMapper;

    @Override
    public DhikrDto addDhikr(DhikrDto dto) {
        Dhikr dhikr = dhikrMapper.toEntity(dto);
        dhikrRepository.save(dhikr);
        return dhikrMapper.toDto(dhikr);
    }

    @Override
    public void deleteById(Long id) {
        dhikrRepository.deleteById(id);
    }
}
