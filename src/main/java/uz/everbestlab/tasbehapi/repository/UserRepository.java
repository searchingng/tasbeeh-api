package uz.everbestlab.tasbehapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.everbestlab.tasbehapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
