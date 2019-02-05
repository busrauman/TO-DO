package com.huawei.todo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huawei.todo.model.Task;
import com.huawei.todo.service.TaskService;

@RestController
@RequestMapping("/api/task")
@CrossOrigin("*")
public class TaskRestController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value="/todo/{id}",consumes = "application/json",method=RequestMethod.POST)
	public ResponseEntity<Task> addTaskTodoList(@RequestBody Task task,@PathVariable Long id) {
		if(id !=  null && task != null) {
				 taskService.addTask(id, task);
				return new ResponseEntity<Task>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Task>(HttpStatus.NOT_ACCEPTABLE);//406
	}

}
