package com.example.SpringMiniProject1.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.example.SpringMiniProject1.model.User;

@Repository
public interface UserRepository {
	
	@Select("SELECT id,username,email,gender, phonenumber,status,user_hash FROM users")
	public List<User> userList();	
	/**
	 * 
	 * for insert data into database
	 */
	@Insert("INSERT INTO users(username,email,gender,phonenumber,status,user_hash) VALUES(#{user.username},#{user.email},#{user.gender},#{user.phonenumber},#{user.status},#{user.user_hash})")
	public boolean save(@Param("user") User user);
	
	@Delete("UPDATE users SET status='0' WHERE user_hash=#{user_hash}")
	public boolean delete(@Param("user_hash") String user_hash);
	
	@Update("UPDATE users SET username=#{user.username} WHERE user_hash=#{user.user_hash}")
	public boolean update(@Param("user") User user);
	
	@Select("SELECT id, username, email, gender, phonenumber, user_hash FROM users WHERE user_hash=#{user_hash}")
	User findOne(@Param("user_hash") String user_hash);
	
	@Select("SELECT COUNT(gender) FROM users WHERE gender= male=#{Male}")
	public boolean getMale(@Param("male") String male);
}
