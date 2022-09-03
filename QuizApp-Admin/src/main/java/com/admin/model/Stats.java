package com.admin.model;

public class Stats {
	
	private int quizCount;
	private int questionsCount;
	private int userCount;
	
	
	
	public Stats(int quizCount, int questionsCount, int userCount) {
		super();
		this.quizCount = quizCount;
		this.questionsCount = questionsCount;
		this.userCount = userCount;
	}
	public Stats() {
	}
	public int getQuizCount() {
		return quizCount;
	}
	public void setQuizCount(int quizCount) {
		this.quizCount = quizCount;
	}
	public int getQuestionsCount() {
		return questionsCount;
	}
	public void setQuestionsCount(int questionsCount) {
		this.questionsCount = questionsCount;
	}
	public int getUserCount() {
		return userCount;
	}
	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
	
	

}
