package com.project.quiz.dao;

import java.util.List;

import com.project.quiz.model.History;

public interface HistoryDAO {
	void insert(History history);
	void update(History history);
	History get(String historyId);
	List<History> getHistoryListByUser(int userId);
}
