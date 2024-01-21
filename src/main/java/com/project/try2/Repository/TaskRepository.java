package com.project.try2.Repository;

import com.project.try2.Entity.Task;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends CrudRepository<Task,Integer> {
    List<Task> findByDateAndLevel(LocalDate date, Integer level);
    List<Task> findByDate(LocalDate date);
    List<Task> findByLevel(Integer level);
}
