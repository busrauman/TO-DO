package com.huawei.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huawei.todo.model.Task;
import com.huawei.todo.model.TodoList;
import com.huawei.todo.repository.TaskRepository;
import com.huawei.todo.repository.TodoRepository;


@Service
public class TaskService {
	
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired 
	private TodoRepository todoRepository;
	//add task to list
	//delete task 
	//get Task
	//getTaskList
	
	
	public Task addTask(Long todoId,Task task) {
		TodoList todo = todoRepository.getOne(todoId);
		if(task != null && todo != null) {
			task.setTodo(todo);
			taskRepository.save(task);
		}
		return task;
	}
	
	public Task getTask(Long id) {
		
		return null;
	}
	

	public void deleteTask(Long id) {
		
	}
	
	public List<Task> getTaskList(Long todoId) {
		return null;
	}
	
	
	//set status
	public void toggleStatus(Long id, boolean mark) {
		
	}
	
}
