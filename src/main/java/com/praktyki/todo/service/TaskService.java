package com.praktyki.todo.service;


import com.praktyki.todo.model.Project;
import com.praktyki.todo.model.Task;
import com.praktyki.todo.model.TaskDTO;
import com.praktyki.todo.repo.TaskRepo;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;


@Service
public class TaskService {

private TaskRepo taskRepo;
private ProjectService projectService;

    public TaskService(TaskRepo taskRepo, ProjectService projectService) {
        this.taskRepo = taskRepo;
        this.projectService = projectService;
    }

    public Task getById(Long id){
        return taskRepo.findById(id).orElseThrow();

    }
    public List<TaskDTO> getByProjectId(Long id){
       List<Task> lista=taskRepo.findAllByProjectId(id);
       List<TaskDTO> listaDTO=new ArrayList<>();

        for(int i=0; i < lista.size(); i++){
            System.out.println(lista.get(i));
            TaskDTO taskDTO = new TaskDTO(lista.get(i));
            listaDTO.add(taskDTO);

        }
        return listaDTO;
    }



    public Task addTask(TaskDTO dto){
        Project project=projectService.getById(dto.getProjectId());
        Task task=new Task(dto.getName(),dto.getDesc(),dto.isStatus(),project);
        return taskRepo.save(task);
    }

    public Iterable<Task> getAll(){
        return taskRepo.findAll();
    }

    public void delTask(Long id){
        taskRepo.deleteById(id);
    }

    public Task changeStatus(Long id, boolean status){
        Task task=taskRepo.findById(id).orElseThrow();
        task.setStatus(status);
        return taskRepo.save(task);
    }

}
