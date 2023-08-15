package com.project.quiz.service.impl;

import java.util.List;

import com.project.quiz.dao.UserDAO;
import com.project.quiz.dao.impl.UserDAOImpl;
import com.project.quiz.model.User;
import com.project.quiz.service.UserService;


public class UserServiceImpl implements UserService {
	UserDAO userDAO = (UserDAO) new UserDAOImpl();

	@Override
	public void insert(User user) {
		userDAO.insert(user);	
	}

	@Override
	public void edit(User user) {
		userDAO.update(user);
	}

	@Override
	public void delete(int id) {
		userDAO.delete(id);
	}

	@Override
	public User get(int id) {
		return userDAO.get(id);
	}

	@Override
	public User login(String username, String password) {
		User user = userDAO.get(username);
		if(user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	@Override
	public boolean register(String username, String password, String email, int role) {
		if(userDAO.checkExistUsername(username)) {
			return false;
		}
		userDAO.insert(new User(username,password,email,role));
		return true;
	}

	@Override
	public List<User> getAll() {
		return userDAO.getAll();
	}

	@Override
	public List<User> search(String keyword) {
		return null;
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDAO.checkExistUsername(username);
	}

}