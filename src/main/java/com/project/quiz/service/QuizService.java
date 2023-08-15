package com.project.quiz.service;

import java.util.List;

import com.project.quiz.model.Quiz;

public interface QuizService {
	void insert(Quiz quiz);
	void update(Quiz quiz);
	void delete(int id);
	Quiz get(int id);
	List<Quiz> getAll();
	void updateTotal(int id);
	List<Quiz> getListQuizByCategory(int categoryId);
}
