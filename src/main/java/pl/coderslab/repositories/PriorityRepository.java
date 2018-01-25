package pl.coderslab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import pl.coderslab.entities.Priority;

@Component
public interface PriorityRepository extends JpaRepository<Priority, Long>{

	
	@Query("select priority from Priority priority where isActive = ?1")
	List<Priority> findAllByActive(boolean active);
	
}
