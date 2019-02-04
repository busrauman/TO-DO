package com.huawei.todo.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.huawei.todo.model.TodoList;

@Repository
public interface TodoRepository extends JpaRepository<TodoList,Long> {
	@Query(value = "SELECT * FROM todo  WHERE deleted=false and owner_id=:id", 
		nativeQuery = true	)
	public List<TodoList> findByOwnerId(@Param("id")Long id);
	
	public Optional<TodoList> findById(Long id);
	
	public TodoList save(TodoList todo);

	@Transactional
	@Modifying
	@Query(value ="update todo set deleted=true where id=:id",nativeQuery = true)
	public void delete(@Param("id") Long id);
	
	

}
