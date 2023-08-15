package com.project.quiz.service.impl;

import java.util.List;

import com.project.quiz.dao.HistoryDAO;
import com.project.quiz.dao.impl.HistoryDAOImpl;
import com.project.quiz.model.History;
import com.project.quiz.service.HistoryService;

public class HistoryServiceImpl implements HistoryService{
	private HistoryDAO historyDAO;
	public HistoryServiceImpl() {
		super();
		this.historyDAO = new HistoryDAOImpl();
	}
	@Override
	public void insert(History history) {
		historyDAO.insert(history);		
	}

	@Override
	public History get(String historyId) {
		return historyDAO.get(historyId);
	}

	@Override
	public List<History> getHistoryListByUser(int userId) {
		return historyDAO.getHistoryListByUser(userId);
	}
	@Override
	public void update(History history) {
		historyDAO.update(history);		
	}

}
