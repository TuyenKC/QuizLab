package com.project.quiz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.quiz.dao.AnswerDAO;
import com.project.quiz.jdbc.JDBCConnection;
import com.project.quiz.model.Answer;
import com.project.quiz.model.History;

public class AnswerDAOImpl extends JDBCConnection implements AnswerDAO{

	@Override
	public void insert(Answer answer) {
		String sql = "INSERT Answers(history_id, question_id, answer) VALUES(?,?,?);";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, answer.getHistoryId());
			pstmt.setInt(2, answer.getQuestionId());
			pstmt.setString(3, answer.getAnswer());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public Answer get(String historyId, int questionId) {
		String sql = "SELECT * FROM Answers where history_id = ? and question_id = ?;";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, historyId);
			pstmt.setInt(2, questionId);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Answer answer = new Answer();
				answer.setHistoryId(rs.getString("history_id"));
				answer.setQuestionId(rs.getInt("question_id"));
				answer.setAnswer(rs.getString("answer"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Answer> getAnswerByHistory(String historyId) {
		String sql = "SELECT * FROM Answers where history_id = ? ;";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, historyId);
			ResultSet rs = pstmt.executeQuery();
			List<Answer> answerList = new ArrayList<>();
			while(rs.next()) {
				Answer answer = new Answer();
				answer.setHistoryId(rs.getString("history_id"));
				answer.setQuestionId(rs.getInt("question_id"));
				answer.setAnswer(rs.getString("answer"));
				answerList.add(answer);
			}
			return answerList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
