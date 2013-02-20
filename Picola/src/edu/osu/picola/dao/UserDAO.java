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

	/**
	 * @param courseID the course you want
	 * @return a list of instructors teaching a course
	 */
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
	
	/**
	 * @param courseID the coure you want
	 * @return a list of read-only users for course
	 */
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
	
	/**
	 * @param courseID the course you want
	 * @return a list of student users in a course
	 */
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
	
	/**
	 * @param role the role you want
	 * @return return a list of user with a given role
	 */
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
