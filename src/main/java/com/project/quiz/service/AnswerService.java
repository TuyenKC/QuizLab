package com.project.quiz.service;

import java.util.List;

import com.project.quiz.model.Answer;

public interface AnswerService {
	void insert(Answer answer);
	Answer get(String historyId, int questionId);
	List<Answer> getAnswerByHistory(String historyId);
}
