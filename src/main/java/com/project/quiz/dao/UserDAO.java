package com.project.quiz.dao;

import java.util.List;

import com.project.quiz.model.User;


public interface UserDAO {
	void insert(User user);
	void update(User user);
	void delete(int id);
	User get(int id);
	User get(String username);
	List<User> getAll();
	boolean checkExistUsername(String username);
}