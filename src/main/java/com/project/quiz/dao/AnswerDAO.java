package com.project.quiz.dao;

import java.util.List;

import com.project.quiz.model.Answer;

public interface AnswerDAO {
	void insert(Answer answer);
	Answer get(String historyId, int questionId);
	List<Answer> getAnswerByHistory(String historyId);
}
