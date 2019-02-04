package com.huawei.todo.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huawei.todo.model.User;
import com.huawei.todo.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserRestController {

	
	@Autowired
	private UserService userService;
	  @Autowired
	  private PasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping(consumes = "application/json")
    public User create(@RequestBody User user){
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userService.create(user);
    }
	
	@GetMapping(path = {"/{id}"},consumes = "application/json")
    public Optional<User> findOne(@PathVariable("id") Long id){
        return userService.findById(id);
    }
	
	@GetMapping(path = {"/email/{email}"})
    public User findUserByEmail(@PathVariable("email") String  email){
        return userService.findByUser(email);
    }
	
	
	
}
