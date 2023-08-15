package com.project.quiz.service;

import java.util.List;

import com.project.quiz.model.History;

public interface HistoryService {
	void insert(History history);
	void update(History history);
	History get(String historyId);
	List<History> getHistoryListByUser(int userId);
}
