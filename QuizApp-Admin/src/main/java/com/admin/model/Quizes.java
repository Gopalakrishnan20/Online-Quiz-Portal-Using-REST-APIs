package com.admin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quizes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long qzId;
	private String quizName;
	private boolean published;
	
	public Quizes() {
		super();
	}
	public Quizes(long qzId, String quizName, boolean published) {
		super();
		this.qzId = qzId;
		this.quizName = quizName;
		this.published = published;
	}
	public long getQzId() {
		return qzId;
	}
	public void setQzId(long qzId) {
		this.qzId = qzId;
	}
	public String getQuizName() {
		return quizName;
	}
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
	public boolean isPublished() {
		return published;
	}
	public void setPublished(boolean published) {
		this.published = published;
	}
	@Override
	public String toString() {
		return "Quizes [qzId=" + qzId + ", quizName=" + quizName + ", published=" + published + "]";
	}
	
	

}
