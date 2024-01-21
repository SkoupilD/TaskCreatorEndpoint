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
    @GetMapping()
    public Iterable<Task> getAllTasks(){ return this.taskRepository.findAll(); }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Integer id){
       Optional <Task> task =  this.taskRepository.findById(id);
       if (task.isPresent()) {
           return task.get();
       }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task addTask(@RequestBody Task task){
        return this.taskRepository.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable("id") Integer id, @RequestBody Task t){
        Optional<Task> taskToUpdateOptional = this.taskRepository.findById(id);
        if (!taskToUpdateOptional.isPresent()) {
            return null;
        }
        Task taskToUpdate = taskToUpdateOptional.get();

        if (t.getTitle() != null){taskToUpdate.setTitle(t.getTitle());
        }
        if (t.getText() != null){taskToUpdate.setText(t.getText());
        }
        if (t.getDate() != null){taskToUpdate.setDate(t.getDate());
        }
        if (t.getTime() != null){taskToUpdate.setTime(t.getTime());
        }
        if (t.getLevel() != null){taskToUpdate.setLevel(t.getLevel());
        }
        Task updatedTask = this.taskRepository.save(taskToUpdate);
        return updatedTask;
        }
        @DeleteMapping("/{id}")
    public Task deleteTask(@PathVariable("id") Integer id){
        Optional<Task> taskToDeleteOptional = this.taskRepository.findById(id);
        if (!taskToDeleteOptional.isPresent()){return null;}
        Task taskToDelete = taskToDeleteOptional.get();
        this.taskRepository.delete(taskToDelete);
        return taskToDelete;
        }
    }