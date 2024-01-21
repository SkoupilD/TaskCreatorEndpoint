package com.project.try2.Controller;

import com.project.try2.Entity.Task;
import com.project.try2.Repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RequestMapping("/tasks")
@RestController
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
            this.taskRepository = taskRepository;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task addTask(@RequestBody Task task){
       return this.taskRepository.save(task);
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Integer id){
       Optional <Task> task =  this.taskRepository.findById(id);
       if (task.isPresent()) {
           return task.get();
       }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    @GetMapping()
    public Iterable<Task> getAllTasks(){ return this.taskRepository.findAll(); }
}