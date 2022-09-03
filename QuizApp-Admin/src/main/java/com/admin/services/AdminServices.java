package com.admin.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.admin.model.AdminDetails;
import com.admin.model.LiveQuiz;
import com.admin.model.QnA;
import com.admin.model.Quizes;
import com.admin.model.Stats;
import com.admin.repository.AdminRepo;
import com.admin.repository.QuestionRepository;
import com.admin.repository.QuizesRepository;

@Service
public class AdminServices {
	@Autowired
	QuizesRepository quizesRepository;

	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	AdminRepo adminRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	LiveQuiz quiz=new LiveQuiz();
	

	Quizes quizes=new Quizes();

	public void addQuestions(QnA q) {
		questionRepository.save(q);
	}

	public void setQuizId(long id, long[] qnId) {
		for (int i = 0; i < qnId.length; i++) {
			if (questionRepository.findById(qnId[i]).isPresent()) {
				QnA old=questionRepository.findById(qnId[i]).get();
				old.setQzId(id);
				questionRepository.save(old);
			}
		}

	}
	public void addQuiz(Quizes qz) {
		quizesRepository.save(qz);		
	}
	
	@SuppressWarnings("null")
	public LiveQuiz getQuiz(Long qzId){
		
		List<QnA> list=	questionRepository.getByQzId(qzId);
		Quizes q= quizesRepository.findById(qzId).get();
		long[] qId= new long[5];
		String c;
		String[] question=new String[5];//From QnA
		String[] option1=new String[5];//From QnA
		String[] option2=new String[5];//From QnA
		String[] option3=new String[5];//From QnA
		String[] option4=new String[5];
		
		int i=0;
		for(QnA a:list)
		{
			qId[i]=a.getqId();
			question[i]=a.getQuestion();
			option1[i]=a.getOption1();
			option2[i]=a.getOption2();
			option3[i]=a.getOption3();
			option4[i]=a.getOption4();
			i++;
		}
		quiz.setQuizId(qzId);
		quiz.setqId(qId);
		quiz.setQuestion(question);
		quiz.setOption1(option1);
		quiz.setOption2(option2);
		quiz.setOption3(option3);
		quiz.setOption4(option4);
		quiz.setQuizName(q.getQuizName());
		
	return quiz;
	}
	
	public String[] getAnswers(long qzId) {
		
		String[] quizanswers=new String[5];		
		List<QnA> qna=questionRepository.getByQzId(qzId);
		int i=0;
		for(QnA a:qna) {
			quizanswers[i]=a.getAnswer();
			i++;
		}
		return quizanswers;
		
	}
	public List<Quizes> showQuizes() {
		List<Quizes> q=quizesRepository.findAllByPublished(true);
		return q;
	}
	public Stats generateStats() {
		Stats stat=new Stats();
		stat.setQuizCount(quizesRepository.findAllByPublished(true).size());
		stat.setQuestionsCount(questionRepository.findAll().size());
		stat.setUserCount(restTemplate.getForObject("http://localhost:8082/user/userCount", Integer.class));
		return stat;
	}
	
	public boolean checkCred(String uname,String pass) {
		
		AdminDetails cred=adminRepo.findByaUname(uname);
		if(cred.getaUname().matches(uname)&&cred.getaPass().matches(pass)) {
			return true;			
		}
		else
			return false;
		
	}

}
