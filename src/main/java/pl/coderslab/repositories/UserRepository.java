package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import pl.coderslab.entities.User;

@Component
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select user from User user where login = ?1")
	User findByLogin(String login);
}
