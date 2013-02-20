package edu.osu.picola.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.osu.picola.dataobjects.User;

public class GroupDAO extends DAO {

	public GroupDAO(Connection conn) {
		super(conn);
	}
	
	public List<User> getGroupMembers(int group_id) {
		List<User> groupMembers = new ArrayList<User>();
		String query = "SELECT * FROM group WHERE group_id ='"
			+group_id+"'";
		ResultSet rs = queryDB(query);
		
		try {
			while (rs.next()) {
				groupMembers.add(new User(rs));
			}
		} catch (SQLException e) {
			System.out.println("Failed to load group members!");
			e.printStackTrace();
		}
		
		return new ArrayList<User>();
	}
}
