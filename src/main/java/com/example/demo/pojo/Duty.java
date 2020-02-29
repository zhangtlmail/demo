package com.example.demo.pojo;

import java.io.Serializable;
import java.util.Date;


public class Duty implements Serializable{
	private static final long serialVersionUID = 1L;
	private int dtID;
	private int userId;
	private Date dtDate;
	private String signinTime;
	private String signoutTime;
	
	private User user;
	
	
	public Duty() {
		super();
	}
	public Duty(int userId, Date dtDate, String signinTime) {
		super();
		this.userId = userId;
		this.dtDate = dtDate;
		this.signinTime = signinTime;
	}
	public int getDtID() {
		return dtID;
	}
	public void setDtID(int dtID) {
		this.dtID = dtID;
	}
	public Date getDtDate() {
		return dtDate;
	}
	public void setDtDate(Date dtDate) {
		this.dtDate = dtDate;
	}
	public String getSigninTime() {
		return signinTime;
	}
	public void setSigninTime(String signinTime) {
		this.signinTime = signinTime;
	}
	public String getSignoutTime() {
		return signoutTime;
	}
	public void setSignoutTime(String signoutTime) {
		this.signoutTime = signoutTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
