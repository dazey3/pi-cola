package edu.osu.picola.dao;

import java.sql.Connection;
import java.util.List;

import edu.osu.picola.dataobjects.Post;

public class DBConnectionTest {
// TODO DELETEME once done with me
	/**
	 * DELETEME 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = MySQLDBConnection.getConnection();
		UserDAO uDao = new UserDAO(conn);
		List<String> students = uDao.getClassRoster("1");
		System.out.println(students.size());
		for(int i =0; i < students.size();i++) {
			System.out.println("studen id = "+ students.get(i));
		}
		PostDAO pDao = new PostDAO(conn);
		List<Post> posts = pDao.getPostByUserId(1);
		for (int i = 0; i < posts.size();i++) {
			System.out.println(posts.get(i).getPost_text());
		}
	}

}
