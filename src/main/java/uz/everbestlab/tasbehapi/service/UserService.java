package uz.everbestlab.tasbehapi.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartFile;
import uz.everbestlab.tasbehapi.dto.LoginDto;
import uz.everbestlab.tasbehapi.dto.UserDto;

public interface UserService {

    LoginDto login(UserDto userDto);

    UserDto upload(MultipartFile multipartFile);

    byte[] openFile(String fileName);

}
