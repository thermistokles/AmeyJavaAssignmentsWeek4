package com.example912.demo912.service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example912.demo912.model.User;
import com.example912.demo912.repo.UserRepository;

@Service
public interface IUserService extends UserRepository {
	
	User save(User user);
	List<User> findAll();
	User getById(long userId);
	void deleteById(long userId);	
	List<User> findByAge(int age);
	List<User> findUserByEmail(@Param("email") String email);

}
