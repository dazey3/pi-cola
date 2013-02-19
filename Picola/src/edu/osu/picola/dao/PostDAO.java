package edu.osu.picola.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.osu.picola.dataobjects.Post;

public class PostDAO extends DAO {
	public PostDAO(Connection conn) {
		super(conn);
	}
	
	public List<Post> getPostByUserId(int user_id) {
		List<Post> postByUser = new ArrayList<Post>();
		
		String query = "SELECT * FROM post WHERE user_id = '" + user_id+"'";
		ResultSet rs = queryDB(query);
		
		try {
			while (rs.next()) {
				Post p = new Post();
				p.setBP_bit(rs.getBoolean("BP_bit"));
				p.setGroup_id(rs.getInt("group_id"));// .getInt("group_id"));
				p.setIs_flagged(rs.getBoolean("is_flagged"));
				p.setMP_bit(rs.getBoolean("MP_bit"));
				p.setPost_id(rs.getInt("post_id"));
				p.setPost_text(rs.getString("post_text"));
				p.setPost_time(rs.getDate("post_time"));
				p.setSummary_bit(rs.getBoolean("summary_bit"));
				p.setUser_id(rs.getInt("group_id"));
				
				postByUser.add(p);
			}
		} catch (SQLException e) {
			System.out.println("SQL failure: "+ e.getMessage());
			e.printStackTrace();
		}
		return postByUser;
	}
	
	
}
