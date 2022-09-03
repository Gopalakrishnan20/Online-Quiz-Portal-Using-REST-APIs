package com.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QnA {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long qId;
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String answer;
	@Column(name="qzId",updatable=true,nullable=true)
	private long qzId;
	public long getqId() {
		return qId;
	}
	public void setqId(long qId) {
		this.qId = qId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public long getQzId() {
		return qzId;
	}
	public void setQzId(long qzId) {
		this.qzId = qzId;
	}
	
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	@Override
	public String toString() {
		return "QnA [qId=" + qId + ", question=" + question + ", option1=" + option1 + ", option2=" + option2
				+ ", option3=" + option3 + ", option4=" + option4 + ", answer=" + answer + ", qzId=" + qzId + "]";
	}
	
	

	
}
