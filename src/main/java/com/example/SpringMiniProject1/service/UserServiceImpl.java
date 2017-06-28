package com.example.SpringMiniProject1.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringMiniProject1.model.User;
import com.example.SpringMiniProject1.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> userList() {
		
		return userRepository.userList();
	}

	@Override
	public boolean save(User user) {
		String user_hash=UUID.randomUUID().toString();
		user.setUser_hash(user_hash);
		user.setStatus("1");
		return userRepository.save(user);
	}

	@Override
	public boolean delete(String user_hash) {
		
		return userRepository.delete(user_hash);
	}

	@Override
	public boolean update(User user) {
		
		return userRepository.update(user);
	}

	@Override
	public User findOne(String user_hash) {
		
		return userRepository.findOne(user_hash);
	}


}
