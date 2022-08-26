package uz.everbestlab.tasbehapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.everbestlab.tasbehapi.dto.LoginDto;
import uz.everbestlab.tasbehapi.dto.UserDto;
import uz.everbestlab.tasbehapi.entity.User;
import uz.everbestlab.tasbehapi.entity.enums.Role;
import uz.everbestlab.tasbehapi.service.mapper.UserMapper;
import uz.everbestlab.tasbehapi.repository.UserRepository;
import uz.everbestlab.tasbehapi.security.jwt.JwtUtil;
import uz.everbestlab.tasbehapi.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtUtil jwtUtil;

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
}
