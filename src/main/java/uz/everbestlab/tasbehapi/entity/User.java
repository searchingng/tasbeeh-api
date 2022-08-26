package uz.everbestlab.tasbehapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User extends BaseEntity{

    private String firstName;
    private String lastName;

}
