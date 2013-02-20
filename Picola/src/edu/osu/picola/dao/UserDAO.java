package edu.osu.picola.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.osu.picola.dataobjects.User;

public class UserDAO extends DAO{

	public UserDAO(Connection conn) {
		super(conn);
	}

	public List<User> getInstructor(int courseID) {
		List<User> readOnlyRoster = new ArrayList<User>();

		String query = "SELECT * FROM teaches WHERE course_id ='"
				+ courseID + "'";

		ResultSet rs = queryDB(query);
		
		try {
			while (rs.next()) {
				readOnlyRoster.add(new User(rs));
			}
		} catch (SQLException e) {
			System.out.println("Error message: " +e.getMessage());
			e.printStackTrace();
		}
		
		return readOnlyRoster;
	}
	
	public List<User> getReadOnly(int courseID) {
		List<User> readOnlyRoster = new ArrayList<User>();

		String query = "SELECT * FROM read-only WHERE course_id ='"
				+ courseID + "'";

		ResultSet rs = queryDB(query);
		
		try {
			while (rs.next()) {
				readOnlyRoster.add(new User(rs));
			}
		} catch (SQLException e) {
			System.out.println("Error message: " +e.getMessage());
			e.printStackTrace();
		}
		
		return readOnlyRoster;
	}
	
	public List<User> getClassRoster(int courseID) {
		List<User> courseRoster = new ArrayList<User>();

		String query = "SELECT * FROM enrolled WHERE course_id ='"
				+ courseID + "'";
		System.out.println("query = "+query);
		ResultSet rs = queryDB(query);
		
		try {
			while (rs.next()) {
				courseRoster.add(new User(rs));
			}
		} catch (SQLException e) {
			System.out.println("Error message: " +e.getMessage());
			e.printStackTrace();
		}
		
		return courseRoster;
	}
	
	public List<User> getUserRole(int role) {
		List<User> userWithRole = new ArrayList<User>();
		
		String query = "SELECT * FROM user WHERE role_id = '"
					 + role+ "'";
		ResultSet rs = queryDB(query);
		try {
			while (rs.next()) {
				userWithRole.add(new User(rs));
			}
		} catch (SQLException e) {
			System.out.println("Error message: " +e.getMessage());
			e.printStackTrace();
		}
		return userWithRole;
	}
}
