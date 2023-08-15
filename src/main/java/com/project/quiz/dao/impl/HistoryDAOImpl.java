package com.project.quiz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.quiz.dao.HistoryDAO;
import com.project.quiz.jdbc.JDBCConnection;
import com.project.quiz.model.Category;
import com.project.quiz.model.History;

public class HistoryDAOImpl extends JDBCConnection implements HistoryDAO {

	@Override
	public void insert(History history) {
		String sql = "INSERT Histories(history_id,user_id, quiz_id,score) VALUES(?,?,?,?);";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,history.getHistoryId());
			pstmt.setInt(2, history.getUserId());
			pstmt.setInt(3, history.getQuizId());
			pstmt.setInt(4, 0);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<History> getHistoryListByUser(int userId) {
		String sql = "SELECT * FROM Histories where user_id = ?;";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			List<History> historyList = new ArrayList<>();
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				History history = new History();
				history.setHistoryId(rs.getString("history_id"));
				history.setQuizId(rs.getInt("quiz_id"));
				history.setUserId(rs.getInt("user_id"));
				history.setScore(rs.getInt("score"));
				historyList.add(history);
			}
			return historyList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public History get(String historyId) {
		String sql = "SELECT * FROM Histories where history_id = ?;";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, historyId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				History history = new History();
				history.setHistoryId(rs.getString("history_id"));
				history.setQuizId(rs.getInt("quiz_id"));
				history.setUserId(rs.getInt("user_id"));
				history.setScore(rs.getInt("score"));
				return history;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(History history) {
		String sql = "UPDATE Histories SET score = ? where history_id = ?";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, history.getScore());
			pstmt.setString(2, history.getHistoryId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
}
