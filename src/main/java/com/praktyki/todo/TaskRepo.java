package com.praktyki.todo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long> {

}
