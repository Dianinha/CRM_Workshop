package pl.coderslab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import pl.coderslab.entities.Project;

@Component
public interface ProjectRepository extends JpaRepository<Project, Long>{

	@Query("select project from Project project where isActive = ?1")
	List<Project> findAllByActive(boolean active);
	
	List<Project> findTop5ByOrderByCreatedDesc();
	
}
