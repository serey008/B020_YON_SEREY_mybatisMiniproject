package com.example.SpringMiniProject1.service;

import java.util.List;

import com.example.SpringMiniProject1.model.User;

public interface UserService {
	
	public List<User> userList();
	public boolean save(User user);
	public boolean delete(String user_hash);
	public boolean update(User user);
	public User findOne(String user_hash);

}
