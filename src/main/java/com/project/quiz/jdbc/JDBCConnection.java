package com.project.quiz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	public static Connection getJDBCConnection() {
		Connection connection = null;
		String user = "root";
		String password = "Tuyenkhuc9x@";
		String url = "jdbc:mysql://localhost:3306/quizweb?useSSL=false";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url,user,password);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
