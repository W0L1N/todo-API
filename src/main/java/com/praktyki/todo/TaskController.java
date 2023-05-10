package com.praktyki.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskRepo taskRepo;

    @Autowired
    public TaskController(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @GetMapping
    public Task getById(@RequestParam Long id){
        return taskRepo.findById(id).orElseThrow();
    }

    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskRepo.save(task);
    }

    @GetMapping("/all")
    public Iterable<Task> getAll(){
        return taskRepo.findAll();
    }

    @DeleteMapping
    public void delTask(@RequestParam Long id){
        taskRepo.deleteById(id);
    }

    @PatchMapping("/changeStatus")
    public Task changeStatus(@RequestParam Long id,@RequestParam boolean status){
        Task task=taskRepo.findById(id).orElseThrow();
        task.setStatus(status);
        return taskRepo.save(task);
    }
}


