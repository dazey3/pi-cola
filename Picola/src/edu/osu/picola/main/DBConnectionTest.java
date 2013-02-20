package edu.osu.picola.main;

import java.sql.Connection;
import java.util.List;

import edu.osu.picola.dao.MySQLDBConnection;
import edu.osu.picola.dao.UserDAO;
import edu.osu.picola.dataobjects.User;

public class DBConnectionTest {
	/**
	 * Sample program perform testing of the DAO and DO 
	 * classes.
	 */
	public static void main(String[] args) {
		/* connect to the db */
		Connection conn = MySQLDBConnection.getConnection();
		
		/* create UserDAO with db connection */
		UserDAO userDAO = new UserDAO(conn);
		
		// DEMO
		
		/* query for all users that role is student */
		List<User> students = userDAO.getUserRole(User.STUDENT);
		
		/* print all students */
		for (int i = 0; i < students.size();i++) {
			students.get(i).printUser();
			System.out.println("=========================================");
		}
	}
}
