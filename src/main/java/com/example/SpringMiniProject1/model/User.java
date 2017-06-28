package com.example.SpringMiniProject1.model;

public class User {
	private int id;
	private String username;
	private String email;
	private String status;
	private String gender;
	private String phonenumber;
	private String user_hash;
	public User()
	{
		
		
	}
	
	public User(int id, String username, String email, String status, String gender, String phonenumber,
			String user_hash) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.status = status;
		this.gender = gender;
		this.phonenumber = phonenumber;
		this.user_hash = user_hash;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getUser_hash() {
		return user_hash;
	}
	public void setUser_hash(String user_hash) {
		this.user_hash = user_hash;
	}

	
	

}
