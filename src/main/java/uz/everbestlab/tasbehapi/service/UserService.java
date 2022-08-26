package uz.everbestlab.tasbehapi.service;

import uz.everbestlab.tasbehapi.dto.LoginDto;
import uz.everbestlab.tasbehapi.dto.UserDto;

public interface UserService {

    LoginDto login(UserDto userDto);

}
