package uz.everbestlab.tasbehapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.everbestlab.tasbehapi.dto.ByteFile;
import uz.everbestlab.tasbehapi.dto.DhikrDto;
import uz.everbestlab.tasbehapi.service.DhikrService;

import java.util.List;

@RestController
@RequestMapping("/api/dhikr")
@RequiredArgsConstructor
public class DhikrController {

    private final DhikrService dhikrService;

    @PostMapping
    public ResponseEntity<DhikrDto> createDhikr(@RequestBody DhikrDto dhikrDto){
        return ResponseEntity.ok(dhikrService.addDhikr(dhikrDto));
    }

    @PostMapping("/upload-voice/{dhikrId}")
    public ResponseEntity<DhikrDto> uploadVoice(@PathVariable("dhikrId") Long dhikrId, @RequestParam("file") MultipartFile multipartFile){
        return ResponseEntity.ok(dhikrService.uploadVoice(dhikrId, multipartFile));
    }

    @GetMapping(value = "/download-voice/{dhikrId}")
    public ResponseEntity<byte[]> download(@PathVariable("dhikrId") Long dhikrId){
        ByteFile file = dhikrService.downloadVoice(dhikrId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.MULTIPART_FORM_DATA_VALUE)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getFileName())
                .body(file.getBody());
    }

    @GetMapping
    public ResponseEntity<List<DhikrDto>> getAll(){
        return ResponseEntity.ok(dhikrService.getAll());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        dhikrService.deleteById(id);
    }

}
