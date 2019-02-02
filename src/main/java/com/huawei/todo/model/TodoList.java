package com.huawei.todo.model;

import java.util.Calendar;
import java.util.List;

public class TodoList {
	
	
	private String name;
	
	private Status status;
	
	private Calendar dueDate;
	
	private User owner;

	private Boolean isDeleted = false;
	
	private List<Task> taskList;
	
}
