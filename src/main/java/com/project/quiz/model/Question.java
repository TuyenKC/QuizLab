package com.project.quiz.model;

public class Question {
	private int questionId,quizId;
	private String content, optionA, optionB, optionC, optionD, correctOption;
	private int score;
	public Question() {
		super();
	}
	public Question(int quizId, String content, String optionA, String optionB, String optionC, String optionD,
			String correctOption, int score) {
		super();
		this.quizId = quizId;
		this.content = content;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.correctOption = correctOption;
		this.score = score;
	}	
	public Question(int questionId, int quizId, String content, String optionA, String optionB, String optionC,
			String optionD, String correctOption, int score) {
		super();
		this.questionId = questionId;
		this.quizId = quizId;
		this.content = content;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.correctOption = correctOption;
		this.score = score;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getQuizId() {
		return quizId;
	}
	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	public String getCorrectOption() {
		return correctOption;
	}
	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}
}
