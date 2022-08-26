package uz.everbestlab.tasbehapi.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.everbestlab.tasbehapi.entity.User;
import uz.everbestlab.tasbehapi.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(Long.parseLong(username))
                .orElseThrow(() -> new AuthenticationServiceException("Unauthorized"));
        return new UserDetailsImpl(user);
    }
}
