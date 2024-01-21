package com.project.try2.Repository;

import com.project.try2.Entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task,Integer> {

}
