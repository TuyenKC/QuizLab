package com.project.quiz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.quiz.dao.UserDAO;
import com.project.quiz.jdbc.JDBCConnection;
import com.project.quiz.model.User;

public class UserDAOImpl extends JDBCConnection implements UserDAO {

	@Override
	public void insert(User user) {
		String sql = "INSERT users(username,password,email,role) VALUES(?,?,?,?);";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setInt(4, user.getRoleId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(User user) {
		String sql = "UPDATE users SET email = ?, password = ?,email = ?, role = ? where user_id = ?";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setInt(4, user.getRoleId());
			pstmt.setInt(5, user.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM users where user_id = ?;";
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
	public User get(int id) {
		String sql = "SELECT * FROM users where user_id = ?;";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);		
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("user_id")); 
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				user.setRoleId(rs.getInt("role"));
				return user;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	

	@Override
	public boolean checkExistUsername(String username) {
		String sql = "SELECT * FROM users where username = ?;";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);		
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User get(String username) {
		String sql = "SELECT * FROM users where username = ?;";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("user_id")); 
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				user.setRoleId(rs.getInt("role"));
				return user;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		String sql = "SELECT * FROM users;";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);		
			ResultSet rs = pstmt.executeQuery();
			List<User> userList = new ArrayList<>();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("user_id")); 
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				user.setRoleId(rs.getInt("role"));
				userList.add(user);	
			}
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

