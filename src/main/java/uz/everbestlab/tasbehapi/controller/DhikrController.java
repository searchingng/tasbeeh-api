package uz.everbestlab.tasbehapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.everbestlab.tasbehapi.dto.DhikrDto;
import uz.everbestlab.tasbehapi.entity.Dhikr;
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

    @GetMapping
    public ResponseEntity<List<DhikrDto>> getAll(){
        return ResponseEntity.ok(dhikrService.getAll());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        dhikrService.deleteById(id);
    }

}
