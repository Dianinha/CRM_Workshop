package pl.coderslab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import pl.coderslab.entities.Task;

@Component
public interface TaskRepository extends JpaRepository<Task, Long>{

	
	@Query("select task from Task task where activeUser_id = ?1")
	List<Task> findByActiveUserId(long id);
}
