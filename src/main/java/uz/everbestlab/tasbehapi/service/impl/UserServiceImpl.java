package uz.everbestlab.tasbehapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import uz.everbestlab.tasbehapi.dto.ByteFile;
import uz.everbestlab.tasbehapi.dto.LoginDto;
import uz.everbestlab.tasbehapi.dto.UserDto;
import uz.everbestlab.tasbehapi.entity.User;
import uz.everbestlab.tasbehapi.entity.enums.Role;
import uz.everbestlab.tasbehapi.security.UserUtil;
import uz.everbestlab.tasbehapi.service.UploadService;
import uz.everbestlab.tasbehapi.service.mapper.UserMapper;
import uz.everbestlab.tasbehapi.repository.UserRepository;
import uz.everbestlab.tasbehapi.security.jwt.JwtUtil;
import uz.everbestlab.tasbehapi.service.UserService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtUtil jwtUtil;
    private final UploadService uploadService;

    @Override
    public LoginDto login(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user.setRole(Role.USER_ROLE);
        userRepository.save(user);
        String jwt = jwtUtil.generateJwtToken(user.getId());
        LoginDto dto = new LoginDto();
        dto.setUser(userMapper.toDto(user));
        dto.setToken(jwt);
        return dto;
    }

    @Override
    public UserDto upload(MultipartFile multipartFile) {
        User user = UserUtil.currentUser();
        String path = uploadService.uploadFile(multipartFile);
        String fileName = path.substring(path.lastIndexOf("/")+1);
        user.setImagePath(path);
        user.setFileName(fileName);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public byte[] openFile(String fileName) {

        Optional<User> optional = userRepository.findByFileName(fileName);

        if (optional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User has not a picture");
        }

        ByteFile file = uploadService.getByteFile(optional.get().getImagePath());
        return file.getBody();
    }
}
