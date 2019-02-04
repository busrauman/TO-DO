package com.huawei.todo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huawei.todo.model.TodoList;
import com.huawei.todo.repository.TodoRepository;

@Service
public class TodoService {
	
	
	@Autowired 
	private TodoRepository todoRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	public void createOrUpdateTodo(TodoList todo) {
		todoRepository.save(todo);
	}
	
	
	public List<TodoList> getTodoList(Long userId){
		
		return todoRepository.findByOwnerId(userId);
	}

	public void deleteTodoList(Long id) {
//		Criteria criteria = em.unwrap(Session.class).createCriteria(TodoList.class);
//		criteria.add(Restrictions.eq("id", id));
//		TodoList todo = (TodoList) criteria.list().get(0);
//		todo.setIsDeleted(true);
		todoRepository.delete(id);
	}
	
	//setStatus True
	public void markAsDone(Long id) {
		
	}
	
	public TodoList getTodo(Long id) {
		return todoRepository.getOne(id);
	}
	
}
