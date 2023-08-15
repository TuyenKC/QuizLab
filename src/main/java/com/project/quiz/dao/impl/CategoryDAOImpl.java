package com.project.quiz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.quiz.dao.CategoryDAO;
import com.project.quiz.jdbc.JDBCConnection;
import com.project.quiz.model.Category;

public class CategoryDAOImpl extends JDBCConnection implements CategoryDAO {

	@Override
	public void insert(Category category) {
		String sql = "INSERT Categories(title, description) VALUES(?,?);";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category.getTitle());
			pstmt.setString(2, category.getDescription());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Category category) {
		String sql = "UPDATE Categories SET title = ?, description = ? where category_id = ?";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category.getTitle());
			pstmt.setString(2, category.getDescription());
			pstmt.setInt(3, category.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM categories where category_id = ?;";
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
	public Category get(int id) {
		String sql = "SELECT * FROM Categories where category_id = ?;";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("category_id"));
				category.setDescription(rs.getString("description"));
				category.setTitle(rs.getString("title"));
				return category;		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> getAll() {
		String sql = "SELECT * FROM Categories;";
		try {
			Connection conn = super.getJDBCConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			List<Category> categoryList = new ArrayList<>();
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("category_id"));
				category.setDescription(rs.getString("description"));
				category.setTitle(rs.getString("title"));
				categoryList.add(category);			
			}
			return categoryList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
