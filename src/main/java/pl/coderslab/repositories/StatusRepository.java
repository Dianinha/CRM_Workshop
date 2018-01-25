package pl.coderslab.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import pl.coderslab.entities.Status;

@Component
public interface StatusRepository extends JpaRepository<Status, Long>{

	@Query("select status from Status status where isActive = ?1")
	List<Status> findAllByActive(boolean active);
}
