package com.project.quiz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.quiz.dao.QuizDAO;
import com.project.quiz.dao.UserDAO;
import com.project.quiz.jdbc.JDBCConnection;
import com.project.quiz.model.Quiz;
import com.project.quiz.model.User;

public class QuizDAOImpl extends JDBCConnection implements QuizDAO {

	@Override
	public void insert(Quiz quiz) {
		String sql = "INSERT quizzes(title, description, total_time, total_question, total_score, category_id) VALUES(?,?,?,?,?,?);";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, quiz.getTitle());
			pstmt.setString(2, quiz.getDescription());
			pstmt.setInt(3, quiz.getTotalTime());
			pstmt.setInt(4, 0);
			pstmt.setInt(5, 0);
			pstmt.setInt(6, quiz.getCategoryId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void update(Quiz quiz) {
		String sql = "UPDATE quizzes SET title = ?, description = ?,total_time = ?, category_id = ? where quiz_id = ?";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, quiz.getTitle());
			pstmt.setString(2, quiz.getDescription());
			pstmt.setInt(3, quiz.getTotalTime());
			pstmt.setInt(4, quiz.getCategoryId());
			pstmt.setInt(5, quiz.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM quizzes where quiz_id = ?;";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public Quiz get(int id) {
		String sql = "SELECT * FROM quizzes where quiz_id = ?;";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Quiz quiz = new Quiz();
				quiz.setId(rs.getInt("quiz_id"));
				quiz.setDescription(rs.getString("description"));
				quiz.setTitle(rs.getString("title"));
				quiz.setTotalTime(rs.getInt("total_time"));
				quiz.setTotalScore(rs.getInt("total_score"));
				quiz.setTotalQuestion(rs.getInt("total_question"));
				quiz.setCategoryId(rs.getInt("category_id"));
				return quiz;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Quiz> getAll() {
		String sql = "SELECT * FROM quizzes;";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			List<Quiz> quizList = new ArrayList<>();
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Quiz quiz = new Quiz();
				quiz.setId(rs.getInt("quiz_id"));
				quiz.setDescription(rs.getString("description"));
				quiz.setTitle(rs.getString("title"));
				quiz.setTotalTime(rs.getInt("total_time"));
				quiz.setTotalScore(rs.getInt("total_score"));
				quiz.setTotalQuestion(rs.getInt("total_question"));
				quiz.setCategoryId(rs.getInt("category_id"));
				quizList.add(quiz);
				
			}
			return quizList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateTotal(int quizId, int totalQuestion, int totalScore) {
		String sql = "UPDATE quizzes SET total_question = ?, total_score=? where quiz_id = ?;";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
	
			pstmt.setInt(1, totalQuestion);
			pstmt.setInt(2, totalScore);
			pstmt.setInt(3, quizId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Quiz> getListQuizByCategory(int categoryId) {		
		String sql = "SELECT * FROM quizzes WHERE category_id = ?;";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, categoryId);
			List<Quiz> quizList = new ArrayList<>();
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Quiz quiz = new Quiz();
				quiz.setId(rs.getInt("quiz_id"));
				quiz.setDescription(rs.getString("description"));
				quiz.setTitle(rs.getString("title"));
				quiz.setTotalTime(rs.getInt("total_time"));
				quiz.setTotalScore(rs.getInt("total_score"));
				quiz.setTotalQuestion(rs.getInt("total_question"));
				quiz.setCategoryId(rs.getInt("category_id"));
				quizList.add(quiz);			
			}
			return quizList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
