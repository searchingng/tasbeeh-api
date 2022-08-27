package uz.everbestlab.tasbehapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.everbestlab.tasbehapi.dto.LoginDto;
import uz.everbestlab.tasbehapi.dto.UserDto;
import uz.everbestlab.tasbehapi.entity.User;
import uz.everbestlab.tasbehapi.security.UserUtil;
import uz.everbestlab.tasbehapi.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginDto> login(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.login(userDto));
    }

    @PostMapping("/upload-picture")
    public ResponseEntity<UserDto> upload(@RequestParam("file") MultipartFile multipartFile){
        return ResponseEntity.ok(userService.upload(multipartFile));
    }

    @GetMapping(value = "/avatar/download/{fileName}")
    public ResponseEntity<byte[]> download(@PathVariable("fileName") String fileName){
        byte[] file = userService.openFile(fileName);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "image/*")
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                .body(file);
    }

    @GetMapping(value = "/avatar/{fileName}", produces = {"image/*"})
    public ResponseEntity<byte[]> getPicture(@PathVariable("fileName") String fileName){
        return ResponseEntity.ok(userService.openFile(fileName));
    }

    @GetMapping("/test")
    public String test(){
        User user = UserUtil.currentUser();
        return user.getFirstName() + " " + user.getLastName();
    }

}
