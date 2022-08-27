package uz.everbestlab.tasbehapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.everbestlab.tasbehapi.entity.enums.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String firstName;
    private String lastName;
    private Role role;
    private String fileName;

}
