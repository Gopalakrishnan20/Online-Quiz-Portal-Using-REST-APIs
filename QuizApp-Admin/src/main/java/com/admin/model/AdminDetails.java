package com.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdminDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long aId;
	@Column(nullable = false)
	private String aUname;
	@Column(nullable = false)
	private String aPass;
	
	
	
	public AdminDetails() {
		
	}
	private String accessToken;
	public AdminDetails(long aId, String aUname, String aPass) {
		super();
		this.aId = aId;
		this.aUname = aUname;
		this.aPass = aPass;
	}
	public long getaId() {
		return aId;
	}
	public void setaId(long aId) {
		this.aId = aId;
	}
	public String getaUname() {
		return aUname;
	}
	public void setaUname(String aUname) {
		this.aUname = aUname;
	}
	public String getaPass() {
		return aPass;
	}
	public void setaPass(String aPass) {
		this.aPass = aPass;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	
	
	

}
