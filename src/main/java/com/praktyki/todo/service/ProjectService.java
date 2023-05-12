package com.praktyki.todo.service;

import com.praktyki.todo.model.Project;
import com.praktyki.todo.repo.ProjectRepo;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private ProjectRepo projectRepo;

    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    public Project getById(Long id){
        return projectRepo.findById(id).orElseThrow();
    }

    public Project addProject(Project project){
        return projectRepo.save(project);
    }

    public Iterable<Project> getAll(){
        return projectRepo.findAll();}

    public void delProject(Long id){
        projectRepo.deleteById(id);
    }


}
