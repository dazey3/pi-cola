package edu.osu.picola.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This is a base dao class for handling
 * constructor and all basic SQL methods 
 */
public class DAO {

	private Connection conn;

	public DAO(Connection conn) {
		this.conn = conn;
	}

	/**
	 * @param query a String representing the SQL query
	 * @return the ResultSet of the query
	 */
	protected ResultSet queryDB(String query) {
		ResultSet rs = null;

		if (conn != null) {

			try {
				PreparedStatement pst = conn.prepareStatement(query);
				rs = pst.executeQuery();
			} catch (SQLException e) {
				System.out.println("query : " + query + " failed!");
				e.printStackTrace();
			}
		} else {
			System.out.println("Connection is null!");
		}

		return rs;
	}

	/**
	 * This method inserts new records into db.
	 * @param insert a String representing insert 
	 * statement
	 */
	protected void insertDB(String insert) {
		if (conn != null) {
			try {
				PreparedStatement pst = conn.prepareStatement(insert);
				pst.execute();
			} catch (SQLException e) {
				System.out.println("insert : " + insert+ " failed!");
				e.printStackTrace();
			}
		} else {
			System.out.println("Connection is null!");
		}
	}
	
	/**
	 * This method updates a record in the db.
	 * @param update a String representation of
	 * the update statement
	 */
	protected void updateDB(String update) {
		if (conn != null) {
			try {
				PreparedStatement pst = conn.prepareStatement(update);
				pst.executeUpdate();
			} catch (SQLException e) {
				System.out.println("update : " + update+ " failed!");
				e.printStackTrace();
			}
		} else {
			System.out.println("Connection is null!");
		}
	}
	
	/**
	 * This method updates a record in the db.
	 * @param delete a String representation of
	 * the update statement
	 */
	protected void deleteRecord(String delete) {
		if (conn != null) {
			try {
				PreparedStatement pst = conn.prepareStatement(delete);
				pst.execute();
			} catch (SQLException e) {
				System.out.println("delete : " + delete+ " failed!");
				e.printStackTrace();
			}
		} else {
			System.out.println("Connection is null!");
		}
	}
	
}
