package uz.everbestlab.tasbehapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.everbestlab.tasbehapi.dto.DhikrDto;
import uz.everbestlab.tasbehapi.entity.Dhikr;
import uz.everbestlab.tasbehapi.service.DhikrService;

@RestController
@RequestMapping("/api/dhikr")
@RequiredArgsConstructor
public class DhikrController {

    private final DhikrService dhikrService;

    @PostMapping
    public ResponseEntity<DhikrDto> createDhikr(@RequestBody DhikrDto dhikrDto){
        return ResponseEntity.ok(dhikrService.addDhikr(dhikrDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        dhikrService.deleteById(id);
    }

}
