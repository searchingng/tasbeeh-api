package uz.everbestlab.tasbehapi.service;

import org.springframework.web.multipart.MultipartFile;
import uz.everbestlab.tasbehapi.dto.ByteFile;
import uz.everbestlab.tasbehapi.dto.DhikrDto;

import java.util.List;

public interface DhikrService {

    DhikrDto addDhikr(DhikrDto dto);

    void deleteById(Long id);

    List<DhikrDto> getAll();

    ByteFile downloadVoice(Long dhikrId);

    DhikrDto uploadVoice(Long dhikrId, MultipartFile multipartFile);
}
