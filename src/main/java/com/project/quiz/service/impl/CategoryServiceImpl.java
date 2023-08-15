package com.project.quiz.service.impl;

import java.util.List;

import com.project.quiz.dao.CategoryDAO;
import com.project.quiz.dao.impl.CategoryDAOImpl;
import com.project.quiz.model.Category;
import com.project.quiz.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	
	private CategoryDAO categoryDAO;
	
	public CategoryServiceImpl() {
		super();
		this.categoryDAO = new CategoryDAOImpl();
	}

	@Override
	public void insert(Category category) {
		categoryDAO.insert(category);		
	}

	@Override
	public void update(Category category) {
		categoryDAO.update(category);		
	}

	@Override
	public void delete(int id) {
		categoryDAO.delete(id);	
	}

	@Override
	public Category get(int id) {
		return categoryDAO.get(id);
	}

	@Override
	public List<Category> getAll() {
		return categoryDAO.getAll();
	}

}
