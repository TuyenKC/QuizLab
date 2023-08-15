package com.project.quiz.dao;

import java.util.List;

import com.project.quiz.model.Quiz;

public interface QuizDAO {
	void insert(Quiz quiz);
	void update(Quiz quiz);
	void delete(int id);
	Quiz get(int id);
	List<Quiz> getAll();
	List<Quiz> getListQuizByCategory(int categoryId);
	void updateTotal(int quizId, int totalQuestion, int totalScore);
}
