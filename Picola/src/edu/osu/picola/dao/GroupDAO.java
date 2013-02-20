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
	
	/**
	 * Removes a member form a team
	 * @param user_id the user to remove
	 * @param group_id the group to remove from
	 */
	public void removeUserFromGroup(int user_id,int group_id) {
		String delete = "DELETE FROM group WHERE user_id = '"
			+ user_id+ "' AND group_id = '"+group_id+"')";
		deleteRecord(delete);
	}
	
	/**
	 * Insert a user into a group
	 * @param user_id the user to insert
	 * @param group_id the group to insert into
	 * @param course_id the course the group is in
	 */
	public void insertUserIntoGroup(int user_id, int group_id, int course_id) {
		String insert = "INSERT INTO group (user_id, group_id, course_id)"
				  + " VALUES ('"
				  + user_id+"', '"
				  + group_id+"', '"
				  + course_id+"')";
		insertDB(insert);
	}
	
	/**
	 * @param group_id the group you want
	 * @return a list of users in the group
	 * TODO consider group object, though its basically
	 * as list, might be handy with get all groups in class
	 */
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
