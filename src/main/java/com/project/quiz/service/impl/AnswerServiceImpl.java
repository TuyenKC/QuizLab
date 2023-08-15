package com.project.quiz.service.impl;

import java.util.List;

import com.project.quiz.dao.AnswerDAO;
import com.project.quiz.dao.impl.AnswerDAOImpl;
import com.project.quiz.model.Answer;
import com.project.quiz.service.AnswerService;

public class AnswerServiceImpl implements AnswerService{
	private AnswerDAO answerDAO;
	
	public AnswerServiceImpl() {
		super();
		this.answerDAO = new AnswerDAOImpl();
	}

	@Override
	public void insert(Answer answer) {
		answerDAO.insert(answer);		
	}

	@Override
	public Answer get(String historyId, int questionId) {
		return answerDAO.get(historyId, questionId);
	}

	@Override
	public List<Answer> getAnswerByHistory(String historyId) {
		return answerDAO.getAnswerByHistory(historyId);
	}

}
