package com.admin.model;


import java.util.Arrays;
import java.util.List;


public class LiveQuiz {
	private long userId;//from UserDetails
	private String userName;//from UserDetails
	private long QuizId;//from QnA
	private String QuizName;//from Quizes
	private long[] qId=new long[5];//from QnA
	private String[] question=new String[5];//From QnA
	private String[] option1=new String[5];//From QnA
	private String[] option2=new String[5];//From QnA
	private String[] option3=new String[5];//From QnA
	private String[] option4=new String[5];//From QnA
	private int result;//calc from method
	private int position;//calc from method
	
	
	public LiveQuiz() {
	}
	@Override
	public String toString() {
		return "LiveQuiz [userId=" + userId + ", userName=" + userName + ", QuizId=" + QuizId + ", QuizName=" + QuizName
				+ ", qId=" + Arrays.toString(qId) + ", question=" + question + ", option1=" + Arrays.toString(option1)
				+ ", option2=" + Arrays.toString(option2) + ", option3=" + Arrays.toString(option3) + ", option4="
				+ Arrays.toString(option4) + ", result=" + result + ", position=" + position + "]";
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getQuizId() {
		return QuizId;
	}
	public void setQuizId(long quizId) {
		QuizId = quizId;
	}
	public String getQuizName() {
		return QuizName;
	}
	public void setQuizName(String quizName) {
		QuizName = quizName;
	}
	public long[] getqId() {
		return qId;
	}
	public void setqId(long[] qId) {
		this.qId = qId;
	}
	public String[] getQuestion() {
		return question;
	}
	public void setQuestion(String[] question) {
		this.question = question;
	}
	public String[] getOption1() {
		return option1;
	}
	public void setOption1(String[] option1) {
		this.option1 = option1;
	}
	public String[] getOption2() {
		return option2;
	}
	public void setOption2(String[] option2) {
		this.option2 = option2;
	}
	public String[] getOption3() {
		return option3;
	}
	public void setOption3(String[] option3) {
		this.option3 = option3;
	}
	public String[] getOption4() {
		return option4;
	}
	public void setOption4(String[] option4) {
		this.option4 = option4;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}

}
