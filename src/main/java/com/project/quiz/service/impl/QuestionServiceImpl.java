package com.project.quiz.service.impl;

import java.util.List;

import com.project.quiz.dao.QuestionDAO;
import com.project.quiz.dao.impl.QuestionDAOImpl;
import com.project.quiz.model.Question;
import com.project.quiz.service.QuestionService;

public class QuestionServiceImpl implements QuestionService {
	
	private QuestionDAO questionDAO;
	public QuestionServiceImpl() {
		super();
		this.questionDAO = new QuestionDAOImpl();
	}
	@Override
	public void insert(Question question) {
		questionDAO.insert(question);		
	}
	@Override
	public void update(Question question) {
		questionDAO.update(question);
	}
	@Override
	public void delete(int questionId) {
		questionDAO.delete(questionId);
	}
	@Override
	public Question get(int id) {
		return questionDAO.get(id);
	}
	@Override
	public List<Question> getQuestionListByQuiz(int quizId) {
		return questionDAO.getQuestionListByQuiz(quizId);
	}
	@Override
	public int getTotalQuestionByQuiz(int quizId) {
		return questionDAO.getTotalQuestionByQuiz(quizId);
	}
	@Override
	public int getTotalPointByQuiz(int quizId) {
		return questionDAO.getTotalPointByQuiz(quizId);
	}
	
}
