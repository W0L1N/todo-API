package com.praktyki.todo.controller;

import com.praktyki.todo.model.Project;
import com.praktyki.todo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/project")
public class ProjectController {
    private ProjectService projectService;

    @Autowired

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public Project getById(@RequestParam Long id){
        return projectService.getById(id);
    }

    @PostMapping
    public Project addProject(@RequestBody Project project){
        return projectService.addProject(project);
    }

    @GetMapping("/all")
    public Iterable<Project> getAll(){
        return projectService.getAll();
    }

    @DeleteMapping
    public void delProject(@RequestParam Long id){projectService.delProject(id);}
}
