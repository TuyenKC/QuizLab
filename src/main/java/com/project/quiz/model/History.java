package com.project.quiz.model;

public class History {
	private String historyId;
	private int userId, quizId, score;

	public History() {
		super();
	}
	
	public History(String historyId, int userId, int quizId, int score) {
		super();
		this.historyId = historyId;
		this.userId = userId;
		this.quizId = quizId;
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getHistoryId() {
		return historyId;
	}

	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}	
}
