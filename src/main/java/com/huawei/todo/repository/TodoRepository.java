package com.huawei.todo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huawei.todo.model.TodoList;

public interface TodoRepository extends JpaRepository<TodoList,Long> {
	
	public List<TodoList> findByOwnerId(Long id);
	
	public Optional<TodoList> findById(Long id);
	
	

}
