package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import pl.coderslab.entities.UserRole;

@Component
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

	@Query("select userRole from UserRole userRole where role = ?1")
	UserRole findByRole(String role);
}
