package com.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.LiveQuiz;
import com.user.model.UserDetails;
import com.user.repository.UserDetailsRepository;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserDetailsRepository userDetailsRepo;
	
	
	@PostMapping("/signup")
	public String signup(UserDetails user) {
		if(user==null)
		{
			return "Enter Details";
		}
		userService.addUser(user);	
		return "Registered Successfully";
	}
	
	@PostMapping("/signin")
	public String signin(String userName,String password) {
		if(userService.checkUser(userName, password))
		{
		return "Login Successfull";
		}
		else {
			return "Invalid Details";
		}
		
	}
	
	@GetMapping("/getQuiz/{id}")
	public LiveQuiz getQuiz(@PathVariable long id) {
		return userService.getQuiz(id);
	}
	
	@PostMapping("/submitQuiz")
	public LiveQuiz submitQuiz(@RequestParam long qzId,@RequestParam String[] response) {
		return userService.submitQuiz(qzId,response);
	}
	@GetMapping("/checkPosition")
	public Map<Integer, Integer> checkPosition() {
		return userService.checkPositions();
	}

}
