package com.huawei.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.huawei.todo.model.Task;
import com.huawei.todo.model.TodoList;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
	@Query(value = "SELECT * FROM task  WHERE deleted=false and todo_id=:id", 
			nativeQuery = true)
	public List<Task> findByTodoId(@Param("id") Long id);
	
	@Transactional
	@Modifying
	@Query(value ="update task set deleted=true where id=:id",nativeQuery = true)
	public void delete(@Param("id") Long id);
	
	
}
