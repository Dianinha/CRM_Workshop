package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import pl.coderslab.entities.Activity;

@Component
public interface ActivityRepository extends JpaRepository<Activity, Long>{

	
	
}
