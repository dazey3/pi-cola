package edu.osu.picola.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.osu.picola.dataobjects.Post;

/**
 * This class is responsible for handling
 * all SQL directly related to the post
 * table.
 * 
 * TODO add queries based off time
 * @author akers.79
 */
public class PostDAO extends DAO {
	public PostDAO(Connection conn) {
		super(conn);
	}

	/**
	 * @param user_id
	 *            the user who made the posts
	 * @return a list of Posts made by a specific user
	 */
	public List<Post> getPostByUserId(int user_id) {
		List<Post> postByUser = new ArrayList<Post>();

		String query = "SELECT * FROM post WHERE user_id = '" + user_id + "'";
		ResultSet rs = queryDB(query);

		try {
			/* populate list from ResultSet */
			while (rs.next()) {
				postByUser.add(new Post(rs));
			}
		} catch (SQLException e) {
			System.out.println("SQL failure: " + e.getMessage());
			e.printStackTrace();
		}
		return postByUser;
	}

	/**
	 * @param group_id
	 *            the group who posts you want
	 * @return a list of post made by a group
	 */
	public List<Post> getPostByGroupId(int group_id) {
		List<Post> postByUser = new ArrayList<Post>();

		String query = "SELECT * FROM post WHERE group_id = '" + group_id + "'";
		ResultSet rs = queryDB(query);

		try {
			/* populate list from ResultSet */
			while (rs.next()) {
				postByUser.add(new Post(rs));
			}
		} catch (SQLException e) {
			System.out.println("SQL failure: " + e.getMessage());
			e.printStackTrace();
		}
		return postByUser;
	}

	/**
	 * @param user_id
	 *            the student you want
	 * @param group_id
	 *            the group you want
	 * @return a list of Posts made by one user in one group
	 */
	public List<Post> getPostByUserId(int user_id, int group_id) {
		List<Post> postByUser = new ArrayList<Post>();

		String query = "SELECT * FROM post WHERE user_id = '" + user_id + "'"
				+ " AND group_id = '" + group_id + "'";
		ResultSet rs = queryDB(query);

		try {
			/* populate list from ResultSet */
			while (rs.next()) {
				postByUser.add(new Post(rs));
			}
		} catch (SQLException e) {
			System.out.println("SQL failure: " + e.getMessage());
			e.printStackTrace();
		}
		return postByUser;
	}

	/**
	 * @return a list of all Posts that have been flagged
	 */
	public List<Post> getFlaggedPosts() {
		List<Post> postByUser = new ArrayList<Post>();

		String query = "SELECT * FROM post WHERE is_flagged is true";
		ResultSet rs = queryDB(query);

		try {
			/* populate list from ResultSet */
			while (rs.next()) {
				postByUser.add(new Post(rs));
			}
		} catch (SQLException e) {
			System.out.println("SQL failure: " + e.getMessage());
			e.printStackTrace();
		}
		return postByUser;
	}

	/**
	 * @return a list of all Posts that have been flagged
	 */
	public List<Post> getSummaryPostInGroup(int group_id) {
		List<Post> postByUser = new ArrayList<Post>();

		String query = "SELECT * FROM post WHERE summary_bit is true AND group_id = '"
				+ group_id +"'";
		ResultSet rs = queryDB(query);

		try {
			/* populate list from ResultSet */
			while (rs.next()) {
				postByUser.add(new Post(rs));
			}
		} catch (SQLException e) {
			System.out.println("SQL failure: " + e.getMessage());
			e.printStackTrace();
		}
		return postByUser;
	}

	/**
	 * @param group_id the group you want
	 * @return list of all posts from the mp portion
	 * of a group's discussion
	 */
	public List<Post> getMpPostInGroup(int group_id) {
		List<Post> post = new ArrayList<Post>();

		String query = "SELECT * FROM post WHERE MP_bit is true AND group_id = '" +group_id+"'";
		ResultSet rs = queryDB(query);
		try {
			while (rs.next()) {
				post.add(new Post(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return post;
	}
	
	/**
	 * @param group_id the group you want
	 * @return list of all posts from the bp portion
	 * of a group's discussion
	 */
	public List<Post> getBpPostInGroup(int group_id) {
		List<Post> post = new ArrayList<Post>();

		String query = "SELECT * FROM post WHERE BP_bit is true AND group_id = '" +group_id+"'";
		ResultSet rs = queryDB(query);
		try {
			while (rs.next()) {
				post.add(new Post(rs));
			}
		} catch (SQLException e) {
			System.out.println("query failed: "+ query);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return post;
	}
	
	/*
	 * TODO test this not 100% confident on it
	 */
	public void updatePost(Post post) {
		String update = "UPATE post SET post_id = '" + post.getPost_id()
					  + "', post_text = '" + post.getPost_text() 
					  + "', post_time = " + post.getPost_time()
					  + ", MP_bit = " + post.isMP_bit()
					  + ", BP_bit = " + post.isBP_bit()
					  + ", summary_bit = "+ post.isSummary_bit()
					  + ", is_flagged = "+ post.isSummary_bit()
					  + ", '" + post.getUser_id()
					  + "', '" + post.getGroup_id()
					  + "'";
		updateDB(update);
	}
	
	/**
	 * Removes a single post
	 * 
	 * @param post_id
	 *            the id for the post to delete
	 */
	public void removePost(int post_id) {
		String delete = "DELETE FROM post WHERE post_id = '" + post_id + "'";
		deleteRecord(delete);
	}

	public void removeAllUsersPosts(int user_id) {
		String delete = "DELETE FROM post WHERE post_id = '" + user_id + "'";
		deleteRecord(delete);
	}

	public void removeAllGroupPost(int group_id) {
		String delete = "DELETE FROM post WHERE group_id = '" + +group_id + "'";
		deleteRecord(delete);
	}

	public void removeAllUsersPostInGroup(int user_id, int group_id) {
		String delete = "DELETE FROM post WHERE group_id = '" + +group_id
				+ "' AND user_id = '" + user_id + "'";
		deleteRecord(delete);

	}
}
