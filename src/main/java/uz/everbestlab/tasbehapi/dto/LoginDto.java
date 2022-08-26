package uz.everbestlab.tasbehapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.everbestlab.tasbehapi.entity.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    private String token;
    private UserDto user;

}
