package edu.osu.picola.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDBConnection {

	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/picola";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "CSE5911group4";
	private static Connection conn;
	private static MySQLDBConnection instance;
	
	public static Connection getConnection() {
		if (instance == null) {
			instance = new MySQLDBConnection();
		}
		return conn;
	}
	
	private MySQLDBConnection() {
		try {
			Class.forName(DRIVER_CLASS);
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch(ClassNotFoundException e) {
			System.out.println("Failed to locate "+DRIVER_CLASS+ " driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Failed to establish connection");
			e.printStackTrace();
		}
	}
}
