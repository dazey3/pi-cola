package edu.osu.picola.dataobjects;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
	
	public static final String INSTRUCTOR = "instructor";
	public static final String STUDENT = "student";
	public static final String READ_ONLY = "read_only";
	public static final String ADMIN = "admin";
	
	private int user_id;
	private String f_name;
	private String l_name;
	private String dot_number;
	private String img_path;
	private String status;
	private String profile_decr;
	private Date last_login_date;
	private Date last_update;
	private Date birthday;
	private String gender;
	private String role;
	
	public User(ResultSet rs) {
		try {
			user_id = rs.getInt("user_id");
			f_name = rs.getString("f_name");
			l_name = rs.getString("l_name");
			dot_number = rs.getString("dot_number");
			img_path = rs.getString("img_path");
			status = rs.getString("status");
			profile_decr = rs.getString("profile_decr");
			last_login_date = rs.getDate("last_login_date");
			last_update = rs.getDate("last_update");
			birthday = rs.getDate("birthday");
			gender = rs.getString("gender");
			// TODO add role field 
			// role = res.getstring("role");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User(int user_id, String f_name, String l_name, String dot_number, String gender, String role) {
		this.user_id = user_id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.dot_number = dot_number;
		img_path = null;
		status = null;
		profile_decr = null;
		last_login_date = null;
		last_update = null;
		birthday = null;
		this.gender = gender;
		this.role = role;
	}
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getDot_number() {
		return dot_number;
	}

	public void setDot_number(String dot_number) {
		this.dot_number = dot_number;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProfile_decr() {
		return profile_decr;
	}

	public void setProfile_decr(String profile_decr) {
		this.profile_decr = profile_decr;
	}

	public Date getLast_login_date() {
		return last_login_date;
	}

	public void setLast_login_date(Date last_login_date) {
		this.last_login_date = last_login_date;
	}

	public Date getLast_update() {
		return last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
