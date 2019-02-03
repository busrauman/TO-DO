package com.huawei.todo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huawei.todo.model.User;
import com.huawei.todo.repository.UserRepository;

@Service
public class UserService {
	
    @Autowired
	private UserRepository userRepository;

    public User loadUserByEmail(String username){
        return userRepository.findByEmail(username);
   }
    
   public User create(User user) {
	   return userRepository.save(user);
   }
   
   public Optional<User> findById(Long id) {
	   return userRepository.findById(id);
   }
	
}
