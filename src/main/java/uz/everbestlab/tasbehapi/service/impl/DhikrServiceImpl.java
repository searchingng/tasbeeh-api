package uz.everbestlab.tasbehapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import uz.everbestlab.tasbehapi.dto.ByteFile;
import uz.everbestlab.tasbehapi.dto.DhikrDto;
import uz.everbestlab.tasbehapi.entity.Dhikr;
import uz.everbestlab.tasbehapi.service.UploadService;
import uz.everbestlab.tasbehapi.service.mapper.DhikrMapper;
import uz.everbestlab.tasbehapi.repository.DhikrRepository;
import uz.everbestlab.tasbehapi.service.DhikrService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DhikrServiceImpl implements DhikrService {

    private final DhikrRepository dhikrRepository;
    private final DhikrMapper dhikrMapper;
    private final UploadService uploadService;

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

    @Override
    public List<DhikrDto> getAll() {
        return dhikrMapper.toDto(dhikrRepository.findAll());
    }

    @Override
    public ByteFile downloadVoice(Long dhikrId) {
        Dhikr dhikr = findById(dhikrId);
        return uploadService.getByteFile(dhikr.getVoicePath());
    }

    @Override
    public DhikrDto uploadVoice(Long dhikrId, MultipartFile multipartFile) {
        String path = uploadService.uploadFile(multipartFile);
        Dhikr dhikr = findById(dhikrId);
        dhikr.setVoicePath(path);
        dhikrRepository.save(dhikr);
        return dhikrMapper.toDto(dhikr);
    }

    private Dhikr findById(Long id){
        return dhikrRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dhikr not found"));
    }
}
