package com.user.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.user.model.LiveQuiz;
import com.user.model.UserDetails;
import com.user.model.UserQuizScore;
import com.user.repository.UserDetailsRepository;
import com.user.repository.UserQuizScoreRepository;
import static java.util.stream.Collectors.*;

@Service
public class UserService {
	public static String userName=null;
	
	@Autowired
	UserDetailsRepository userDetailsRepo;	
	
	@Autowired
	UserQuizScoreRepository userQuizScoreRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public void addUser(UserDetails user) {
		userDetailsRepo.save(user);
	}
	
	public boolean checkUser(String uname,String pass) {
		
		UserDetails ud=userDetailsRepo.getByUserName(uname);
		if(ud==null) {
			return false;
		}
		else if(ud.getUserName().matches(uname)&&ud.getPassword().matches(pass)) {
			userName=uname;
			return true;
		}
		else		
		return false;
		
	}
	public UserDetails getUserDetails() {
		UserDetails userDetails=userDetailsRepo.getByUserName(userName);
		return userDetails;
		
	}
	
	public LiveQuiz getQuiz(long id) {
		
		Map<String,Long> params=new HashMap<String,Long>();
		params.put("qzId", (long) id);
		
		LiveQuiz liveQuiz=restTemplate.getForObject("http://localhost:8081/admin/getQuestions/{qzId}", LiveQuiz.class, params);
		liveQuiz.setUserId(getUserDetails().getUserId());
		liveQuiz.setUserName(getUserDetails().getUserName());
		return liveQuiz;
		
	}
	
	public LiveQuiz submitQuiz(long qzId,String[] response) {
		//http://localhost:8080/admin/getAnswers/{qzId}
		Map<String,Long> params=new HashMap<String,Long>();
		params.put("qzId", qzId);
		
		LiveQuiz liveQuiz=getQuiz(qzId);
		String[] answers=restTemplate.getForObject("http://localhost:8081/admin/getAnswers/{qzId}", String[].class, params);
		int i=0,score=0;
		for(String a:answers) {
			response[i] = response[i].replace("[", "").replace("]", "");
			if(response[i].contains(a))
			{
				score++;
			}
			i++;
		}
		liveQuiz.setResponse(response);
		liveQuiz.setAnswers(answers);
		liveQuiz.setResult(score);
		addScore(liveQuiz);
		return liveQuiz;
				
	}
	public void addScore(LiveQuiz result) {
		UserQuizScore userQuizScore=new UserQuizScore();
		userQuizScore.setQzId(result.getQuizId());
		userQuizScore.setUserName(result.getUserName());
		userQuizScore.setScore(result.getResult());
		userQuizScoreRepo.save(userQuizScore);
	}
	
	public Map<String, Integer> checkPositions(long qzId) {
		List<UserQuizScore> scoreList=userQuizScoreRepo.findByQzId(qzId);
		Map<String,Integer> scoreboard= new HashMap<String,Integer>();
		for(UserQuizScore u:scoreList) {
			scoreboard.put(u.getUserName(),u.getScore());
		}
		Map<String, Integer> sorted =scoreboard
		        .entrySet()
		        .stream()
		        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
		        .collect(
		            toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
		                LinkedHashMap::new));
		return sorted;
		}

	public int userCount() {
		return userDetailsRepo.findAll().size();
	}
	
}
