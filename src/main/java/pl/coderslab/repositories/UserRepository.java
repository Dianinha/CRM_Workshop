package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import pl.coderslab.entities.User;

@Component
public interface UserRepository extends JpaRepository<User, Long>{

}
