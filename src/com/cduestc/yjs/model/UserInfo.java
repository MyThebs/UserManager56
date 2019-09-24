package com.cduestc.yjs.model;

//Java Bean ¹æ·¶
public class UserInfo {
	public UserInfo(String id, String name, String pwd, String email, String grade){
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.email = email;
		this.grade = grade;
	}

    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	private String id;
	private String name;
	private String email;
	private String pwd;
	private String grade;
}
