package com.project.quiz.model;

import java.util.Date;

public class Quiz {
	private int id;
	private String title, description;
	private int totalTime, totalQuestion, totalScore;
	private int categoryId;
	public Quiz() {
		super();
	}	
	public Quiz(int id, String title, String description, int totalTime, int totalQuestion, int totalScore,
			int categoryId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description; 
		this.totalTime = totalTime;
		this.totalQuestion = totalQuestion;
		this.totalScore = totalScore;
		this.categoryId = categoryId;
	}
	public Quiz(String title, String description, int totalTime, int totalQuestion, int totalScore, int categoryId) {
		super();
		this.title = title;
		this.description = description;
		this.totalTime = totalTime;
		this.totalQuestion = totalQuestion;
		this.totalScore = totalScore;
		this.categoryId = categoryId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
	public int getTotalQuestion() {
		return totalQuestion;
	}
	public void setTotalQuestion(int totalQuestion) {
		this.totalQuestion = totalQuestion;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}	
}
