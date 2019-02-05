package com.huawei.todo.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huawei.todo.model.TodoList;
import com.huawei.todo.model.User;
import com.huawei.todo.service.TodoService;
import com.huawei.todo.service.UserService;

@RestController
@RequestMapping("/api/todo")
@CrossOrigin("*")
public class TodoRestController {
	
	@Autowired
	private TodoService todoService;
	
	@Autowired
	private UserService userService;
	
	
	
	
	@RequestMapping(value="/user/{id}",produces = "application/json",method=RequestMethod.POST)
	public ResponseEntity<TodoList> createTodoList(@RequestBody(required=true) TodoList todo,@PathVariable Long id) {
		if(id !=  null && todo != null) {
			Optional<User> user = userService.findById(id);
			if(user != null) {
				todo.setOwner(user.get());
				todoService.createOrUpdateTodo(todo);
				return new ResponseEntity<TodoList>(todo,HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<TodoList>(HttpStatus.NOT_ACCEPTABLE);//406
	}
	
	
	@RequestMapping(value="/user/{id}/todos",produces = "application/json",method=RequestMethod.GET)
	public ResponseEntity<List<TodoList>> getAllTodosByUserId(@PathVariable Long id){
		List<TodoList> todos = null;
		if(userService.findById(id) != null) {
		  todos = todoService.getTodoList(id);
		}
		return new ResponseEntity<List<TodoList>>(todos,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/user/todos/{id}",produces = "application/json",method=RequestMethod.DELETE)
	public ResponseEntity<TodoList> deleteTodoById(@PathVariable Long id){
		todoService.deleteTodoList(id);
		return new ResponseEntity<TodoList>(HttpStatus.OK);
	}

	@RequestMapping(value="/user/todos/{id}",produces = "application/json",method=RequestMethod.GET)
	public TodoList getTodoBy(@PathVariable Long id){
		return todoService.getTodo(id);
	}
	

}
