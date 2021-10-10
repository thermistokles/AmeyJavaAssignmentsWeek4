package com.example912.demo912.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.example912.demo912.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByAge(int age);
	//CustomQuery (JPQL Query using Named parameter)
		@Query("SELECT u FROM User u WHERE u.email like %:email%") //Named parameter
		List<User> findUserByEmail(@Param("email") String email);
	 

}
