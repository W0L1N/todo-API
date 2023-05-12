package com.praktyki.todo.controller;

import com.praktyki.todo.model.Task;
import com.praktyki.todo.model.TaskDTO;
import com.praktyki.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public Task getById(@RequestParam Long id){
        return taskService.getById(id);
    }
    @GetMapping("/byProject/{id}")
    public List<TaskDTO> getAllByProjectId(@PathVariable Long id){
        return taskService.getByProjectId(id);

    }
    @PostMapping
    public Task addTask(@RequestBody TaskDTO task){
        return taskService.addTask(task);
    }

    @GetMapping("/all")
    public Iterable<Task> getAll(){
        return taskService.getAll();
    }

    @DeleteMapping
    public void delTask(@RequestParam Long id){
        taskService.delTask(id);
    }

    @PatchMapping("/changeStatus")
    public Task changeStatus(@RequestParam Long id,@RequestParam boolean status){

        return taskService.changeStatus(id, status);
    }


}


