package uz.everbestlab.tasbehapi.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import uz.everbestlab.tasbehapi.entity.enums.Role;
import uz.everbestlab.tasbehapi.security.UserDetailsServiceImpl;
import uz.everbestlab.tasbehapi.security.jwt.AuthTokenFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthTokenFilter authTokenFilter;
    private final UserDetailsServiceImpl userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/dhikr/download-voice/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/users/login").permitAll()
                .antMatchers(HttpMethod.GET, "/api/users/avatar/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/dhikr").hasAuthority(Role.USER_ROLE.name())
                .antMatchers("/api/dhikr/**").hasAuthority(Role.ADMIN_ROLE.name())
                .antMatchers("/api/task/**").hasAuthority(Role.USER_ROLE.name())
                .antMatchers("/api/users/**").hasAuthority(Role.USER_ROLE.name())
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .headers().frameOptions().disable()
                .and();

        return http.build();
    }


}
