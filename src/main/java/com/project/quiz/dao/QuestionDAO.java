package com.project.quiz.dao;

import java.util.List;

import com.project.quiz.model.Question;

public interface QuestionDAO {
	void insert(Question question);
	void update(Question question);
	void delete(int questionId);
	Question get(int id);
	List<Question> getQuestionListByQuiz(int quizId);
	int getTotalQuestionByQuiz(int quizId);
	int getTotalPointByQuiz(int quizId);

}
