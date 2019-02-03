package com.huawei.todo.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="task")
public class Task {
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	@Column
	private String name;
	
	
	@Type(type="text")
	@Column
	private String description;
	
	@Column
	private  Calendar dueDate;
	
	@Column(name="deleted")
	private Boolean isDeleted = false;
	
	@Column(name="done")
	private Boolean isDone = false;
	
	@Column(name = "expired")
	private Boolean isExpired = false;
	
	@ManyToOne
    @JoinColumn(name="todo_id", nullable=false)
	private TodoList todo;
	
	
	public TodoList getTodo() {
		return todo;
	}

	public void setTodo(TodoList todo) {
		this.todo = todo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getDueDate() {
		return dueDate;
	}

	public void setDueDate(Calendar dueDate) {
		this.dueDate = dueDate;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Long getId() {
		return id;
	}

	public Boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}

	public Boolean getIsExpired(){
		if (Calendar.getInstance().before(this.dueDate))
			return true;
		return isExpired;
	}

	public void setIsExpired(Boolean isExpired) {
		this.isExpired = Calendar.getInstance().before(this.dueDate);
	}
	

}
