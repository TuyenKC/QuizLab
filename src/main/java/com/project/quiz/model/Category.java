package com.project.quiz.model;

public class Category {
	private int id;
	private String title, description;
	
	public Category() {
		super();
	}
	public Category(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	public Category(int id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
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
}
