package com.praktyki.todo.repo;

import com.praktyki.todo.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long> {
    List<Task> findAllByProjectId(Long projectId);


}
