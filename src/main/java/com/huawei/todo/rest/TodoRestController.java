package com.huawei.todo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoRestController {
	
	
	@RequestMapping(value= "/" , method =RequestMethod.GET)
	public String create() {
		return "Hello Todo-List";
	}

}
