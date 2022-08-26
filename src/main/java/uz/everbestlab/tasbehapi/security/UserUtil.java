package uz.everbestlab.tasbehapi.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.server.ResponseStatusException;
import uz.everbestlab.tasbehapi.entity.User;

public class UserUtil {

    public static User currentUser(){
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
            User user = details.getUser();
            return user;
        } catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized");
        }
    }

}
