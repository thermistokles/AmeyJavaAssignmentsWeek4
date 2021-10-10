package com.example912.demo912.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example912.demo912.model.User;
import com.example912.demo912.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="*")
@Order(value=2)
public class UserController implements CommandLineRunner {
	
	@Autowired
	private UserService iUserService;
	
	//Custom configuration from properties file
	@Value("${bank.name}")
	private String bankName;
	
	@GetMapping("/")
	public String met() {
		return "Welcome"+bankName;
	}
	
	@PostMapping("/saveUser")
	public User addUser(@Valid @RequestBody User user) {
		return iUserService.save(user);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers()
	{
		Pageable page = PageRequest.of(1, 3, Sort.by("username").descending().and(Sort.by("age")));
		List<User> lUser = iUserService.findAll(page).getContent();
		lUser.stream().forEach((user) -> {System.out.println(user);});
		return iUserService.findAll();
	}
	
	@GetMapping("/getUser/{userId}")
	public User getUser(@PathVariable int userId) {
		return iUserService.getById((long) userId);
	}
	
	@PutMapping("/updateUser/{userId}")
	public String updateUser(@PathVariable int userId) {
		return iUserService.updateUser(userId);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public int deleteUser(@PathVariable int userId) {
		iUserService.deleteById((long) userId);
		return userId;
	}
	
	@GetMapping("/getUserByEmail/{emailId}")
	public List<User> findUserByEmail(@PathVariable String emailId) {
		return iUserService.findUserByEmail(emailId);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Run in controller");
		
	}
}
