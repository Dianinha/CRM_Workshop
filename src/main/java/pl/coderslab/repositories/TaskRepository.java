package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import pl.coderslab.entities.Task;

@Component
public interface TaskRepository extends JpaRepository<Task, Long>{

}
