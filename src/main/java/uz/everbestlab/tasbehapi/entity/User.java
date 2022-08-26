package uz.everbestlab.tasbehapi.entity;

import lombok.Getter;
import lombok.Setter;
import uz.everbestlab.tasbehapi.entity.enums.Role;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User extends BaseEntity{

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Role role;

}
