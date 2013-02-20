package edu.osu.picola.dataobjects;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Course {
	private int course_id;
	private String course_title;
	private String course_descr;
	private int semester_id;

	public Course(ResultSet rs) {
		try {
			course_id = rs.getInt("course_id");
			course_title = rs.getString("course_title");
			course_descr = rs.getString("course_descr");
			semester_id = rs.getInt("semester_id");
		} catch (SQLException e) {
			System.out.println("Failed to read in course!");
			e.printStackTrace();
		}
	}

	public Course(int course_id, String course_title,
				String course_descr, int semester_id) {
		this.course_id = course_id;
		this.course_title = course_title;
		this.course_descr = course_descr;
		this.semester_id = semester_id;
	}
	
	
	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_title() {
		return course_title;
	}

	public void setCourse_title(String course_title) {
		this.course_title = course_title;
	}

	public String getCourse_descr() {
		return course_descr;
	}

	public void setCourse_descr(String course_descr) {
		this.course_descr = course_descr;
	}

	public int getSemester_id() {
		return semester_id;
	}

	public void setSemester_id(int semester_id) {
		this.semester_id = semester_id;
	}
}
