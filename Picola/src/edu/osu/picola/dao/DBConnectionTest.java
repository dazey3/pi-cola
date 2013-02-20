package edu.osu.picola.dao;

import java.sql.Connection;
import java.util.List;
import edu.osu.picola.dataobjects.User;

public class DBConnectionTest {
// TODO DELETEME once done with me
	/**
	 * DELETEME 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = MySQLDBConnection.getConnection();
		UserDAO userDAO = new UserDAO(conn);
		List<User> students =userDAO.getUserRole(User.STUDENT);
		for (int i = 0; i < students.size();i++) {
			System.out.println(students.get(i).getF_name());
		}
	}
}
