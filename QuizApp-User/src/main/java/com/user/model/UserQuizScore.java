package com.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserQuizScore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long resultId;
	private String UserName;
	private int score;
	@Column(name="qzId",updatable=true,nullable=false)
	private long qzId;
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public long getResultId() {
		return resultId;
	}
	public void setResultId(long resultId) {
		this.resultId = resultId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public long getQzId() {
		return qzId;
	}
	public void setQzId(long qzId) {
		this.qzId = qzId;
	}
	@Override
	public String toString() {
		return "UserQuizScore [resultId=" + resultId + ", score=" + score + ", qzId=" + qzId + "]";
	}

	
}
