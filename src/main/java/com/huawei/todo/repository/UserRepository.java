package com.huawei.todo.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.huawei.todo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByEmail(String email);
	
	public User save(User user);
	
	public Optional<User> findById(Long id);
	
	
//	@Transactional
//	@Modifying
//	@Query("update Author p set p.deleted=true where p.id=:id")
//void deleteAuthor(@Param("id") Long id);
}
