package uz.everbestlab.tasbehapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/test")
    public String test(){
        User user = UserUtil.currentUser();
        return user.getFirstName() + " " + user.getLastName();
    }

}
