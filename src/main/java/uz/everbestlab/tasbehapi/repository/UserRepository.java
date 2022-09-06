package uz.everbestlab.tasbehapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.everbestlab.tasbehapi.entity.User;
import uz.everbestlab.tasbehapi.entity.enums.Role;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByFileName(String fileName);

    Optional<User> findByRole(Role role);

}
