package com.praktyki.todo.repo;

import com.praktyki.todo.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends CrudRepository <Project, Long> {

}
