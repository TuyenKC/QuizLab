package com.project.quiz.dao;

import java.util.List;

import com.project.quiz.model.Category;

public interface CategoryDAO {
	void insert(Category category);
	void update(Category category);
	void delete(int id);
	Category get(int id);
	List<Category> getAll();
}
