package edu.osu.picola.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO{

	public UserDAO(Connection conn) {
		super(conn);
	}

	public List<String> getClassRoster(String courseID) {
		List<String> courseRoster = new ArrayList<String>();

		String query = "SELECT user_id FROM Enrolled WHERE course_id ='"
				+ courseID + "'";

		ResultSet rs = queryDB(query);
		
		try {
			while (rs.next()) {
				courseRoster.add(rs.getString("user_id"));
			}
		} catch (SQLException e) {
			System.out.println("Error message: " +e.getMessage());
			e.printStackTrace();
		}
		
		return courseRoster;
	}
}
