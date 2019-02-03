package com.huawei.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huawei.todo.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

//	public findByTodo
}
