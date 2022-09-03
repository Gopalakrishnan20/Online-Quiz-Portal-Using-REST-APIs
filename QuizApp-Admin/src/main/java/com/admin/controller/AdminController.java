package com.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.model.LiveQuiz;
import com.admin.model.QnA;
import com.admin.model.QnArray;
import com.admin.model.Quizes;
import com.admin.services.AdminServices;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminServices adminServices;
	
	@PostMapping("/addQuestions")
	public void addQuestions(@RequestBody QnA q) {
		adminServices.addQuestions(q);
	}
		
	@PostMapping("/createQuiz")
	public void createQuiz(@RequestBody Quizes qz) {
		adminServices.addQuiz(qz);
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
	public void generateStats() {
		
	}
	

}
