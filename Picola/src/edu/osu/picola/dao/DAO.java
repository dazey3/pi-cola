package edu.osu.picola.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

	private Connection conn;

	public DAO(Connection conn) {
		this.conn = conn;
	}

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

}
