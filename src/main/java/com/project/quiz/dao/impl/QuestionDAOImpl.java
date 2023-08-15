package com.project.quiz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.quiz.dao.QuestionDAO;
import com.project.quiz.jdbc.JDBCConnection;
import com.project.quiz.model.Category;
import com.project.quiz.model.Question;

public class QuestionDAOImpl extends JDBCConnection implements QuestionDAO {
	@Override
	public void insert(Question question) {
		String sql = "INSERT Questions(quiz_id, content, option_a, option_b, option_c, option_d, correct_option, score) VALUES(?,?,?,?,?,?,?,?);";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, question.getQuizId());
			pstmt.setString(2, question.getContent());
			pstmt.setString(3, question.getOptionA());
			pstmt.setString(4, question.getOptionB());
			pstmt.setString(5, question.getOptionC());
			pstmt.setString(6, question.getOptionD());
			pstmt.setString(7, question.getCorrectOption());
			pstmt.setInt(8, question.getScore());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void update(Question question) {
		String sql = "UPDATE Questions SET content = ? , option_a = ?, option_b = ?, option_c = ?, option_d = ?, correct_option = ?, score = ? where question_id = ?;";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, question.getContent());
			pstmt.setString(2, question.getOptionA());
			pstmt.setString(3, question.getOptionB());
			pstmt.setString(4, question.getOptionC());
			pstmt.setString(5, question.getOptionD());
			pstmt.setString(6, question.getCorrectOption());
			pstmt.setInt(7, question.getScore());
			pstmt.setInt(8, question.getQuestionId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int questionId) {
		String sql = "DELETE FROM questions where question_id = ?;";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, questionId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Question get(int id) {
		String sql = "SELECT * FROM Questions where question_id = ?;";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Question question = new Question();
				question.setQuestionId(rs.getInt("question_id"));
				question.setQuizId(rs.getInt("quiz_id"));
				question.setContent(rs.getString("content"));
				question.setOptionA(rs.getString("option_a"));
				question.setOptionB(rs.getString("option_b"));
				question.setOptionC(rs.getString("option_c"));
				question.setOptionD(rs.getString("option_d"));
				question.setCorrectOption(rs.getString("correct_option"));
				question.setScore(rs.getInt("score"));
				return question;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Question> getQuestionListByQuiz(int quizId) {
		String sql = "SELECT * FROM Questions where quiz_id = ?;";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, quizId);
			List<Question> questionList = new ArrayList<>();
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Question question = new Question();
				question.setQuestionId(rs.getInt("question_id"));
				question.setQuizId(rs.getInt("quiz_id"));
				question.setContent(rs.getString("content"));
				question.setOptionA(rs.getString("option_a"));
				question.setOptionB(rs.getString("option_b"));
				question.setOptionC(rs.getString("option_c"));
				question.setOptionD(rs.getString("option_d"));
				question.setCorrectOption(rs.getString("correct_option"));
				question.setScore(rs.getInt("score"));
				questionList.add(question);
				
			}
			return questionList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getTotalQuestionByQuiz(int quizId) {
		String sql = "SELECT COUNT(*) FROM Questions where quiz_id = ?;";
		int totalQuestions = 0;
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, quizId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {				
				totalQuestions = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalQuestions;
	}

	@Override
	public int getTotalPointByQuiz(int quizId) {
		String sql = "SELECT SUM(questions.score) FROM Questions where quiz_id = ?;";
		int totalPoints = 0;
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, quizId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {				
				totalPoints = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalPoints;
	}

}
