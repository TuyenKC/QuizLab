package com.project.quiz.model;

public class Answer {
	private int questionId;
	private String historyId, answer;
	
	public Answer() {
		super();
	}
	public Answer(String historyId, int questionId, String answer) {
		super();
		this.historyId = historyId;
		this.questionId = questionId;
		this.answer = answer;
	}
	public String getHistoryId() {
		return historyId;
	}
	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
