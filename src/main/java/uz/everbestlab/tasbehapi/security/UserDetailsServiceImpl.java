package uz.everbestlab.tasbehapi.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.everbestlab.tasbehapi.entity.User;
import uz.everbestlab.tasbehapi.entity.enums.Role;
import uz.everbestlab.tasbehapi.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (username.equals("admin")) {
            Optional<User> optional = userRepository.findByRole(Role.ADMIN_ROLE);
            if (optional.isPresent()){
                return new UserDetailsImpl(optional.get());
            } else {
                User admin = new User();
                admin.setRole(Role.ADMIN_ROLE);
                admin.setFirstName("admin");
                admin.setLastName("admin");
                userRepository.save(admin);
                return new UserDetailsImpl(admin);
            }
        }

        User user = userRepository.findById(Long.parseLong(username))
                .orElseThrow(() -> new AuthenticationServiceException("Unauthorized"));
        return new UserDetailsImpl(user);
    }
}
