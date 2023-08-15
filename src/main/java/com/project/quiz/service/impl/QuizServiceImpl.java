package com.project.quiz.service.impl;

import java.util.List;

import com.project.quiz.dao.QuizDAO;
import com.project.quiz.dao.impl.QuizDAOImpl;
import com.project.quiz.model.Quiz;
import com.project.quiz.service.QuestionService;
import com.project.quiz.service.QuizService;

public class QuizServiceImpl implements QuizService {
	
	private QuizDAO quizDAO;
	
	public QuizServiceImpl() {
		super();
		this.quizDAO = new QuizDAOImpl();
	}

	@Override
	public void insert(Quiz quiz) {
		quizDAO.insert(quiz);
	}

	@Override
	public void update(Quiz quiz) {
		quizDAO.update(quiz);	
	}

	@Override
	public void delete(int id) {
		quizDAO.delete(id);	
	}

	@Override
	public Quiz get(int id) {
		return quizDAO.get(id);
	}

	@Override
	public List<Quiz> getAll() {
		return quizDAO.getAll();
	}

	@Override
	public void updateTotal(int id) {
		QuestionService questionService = new QuestionServiceImpl();
		quizDAO.updateTotal(id, questionService.getTotalQuestionByQuiz(id), questionService.getTotalPointByQuiz(id));
	}

	@Override
	public List<Quiz> getListQuizByCategory(int categoryId) {
		return quizDAO.getListQuizByCategory(categoryId);
	}
	
}
