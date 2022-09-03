package com.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.admin.model.LiveQuiz;
import com.admin.model.QnA;
import com.admin.model.QnArray;
import com.admin.model.Quizes;
import com.admin.model.Stats;
import com.admin.services.AdminServices;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	public static String accessToken=null;
	
	@Autowired
	AdminServices adminServices;
	
	@PostMapping("/signin")
	public String signin(@RequestParam String uname,@RequestParam String pass) {
		if(adminServices.checkCred(uname,pass))
		{
			accessToken="Admin@AccessToken456";
			return "Access Token Generated : "+accessToken;
		}
		else
			return "Invalid Credentials";
	}
	
	@PostMapping("{accessTokenR}/addQuestions")
	public String addQuestions(@PathVariable String accessTokenR, @RequestBody QnA q) {
		if(accessTokenR.matches(accessToken)) {
		adminServices.addQuestions(q);
		return "Questions Added Successfully";
		}
		else {
			return "Enter Proper Access Token";
		}
		
	}
		
	@PostMapping("{accessTokenR}/createQuiz")
	public String createQuiz(@PathVariable String accessTokenR, @RequestBody Quizes qz) {
		if(accessTokenR.matches(accessToken)) {
		adminServices.addQuiz(qz);
		return "Quiz Added successfully";}
		else {
			return "Enter Proper Access Token";
		}
		//adminServices.updateQuestions(qz.getQzId(), qarr.getQnId());				
	}
	@PostMapping("/setQuizId/{id}")
	public void createQuiz(@PathVariable long id, @RequestBody QnArray qarr) {
		//adminServices.addQuiz(qz);
		adminServices.setQuizId(id, qarr.getQnId());				
	}
	
	@GetMapping("/getQuestions/{qzId}")
	public LiveQuiz fetchQuestions(@PathVariable long qzId){
		return adminServices.getQuiz(qzId);
	}
	@GetMapping("/getAnswers/{qzId}")
	public String[] fetchAnswers(@PathVariable long qzId) {
		return adminServices.getAnswers(qzId);
	}
	@GetMapping("/getAvailableQuiz")
	public List<Quizes> showQuizes() {
		return adminServices.showQuizes();		
	}
	@GetMapping("/stats")
	public Stats generateStats() {
		return adminServices.generateStats();
		
	}
	

}
