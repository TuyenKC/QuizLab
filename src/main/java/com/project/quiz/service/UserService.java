package com.project.quiz.service;

import java.util.List;

import com.project.quiz.model.User;


public interface UserService {
	void insert(User user);
	void edit(User user);
	void delete(int id);	
	User get(int id);	
	User login(String username, String password);	
	boolean register(String username, String password, String email, int role);
	List<User> getAll();
	List<User> search(String keyword);	
	boolean checkExistUsername(String username);
}