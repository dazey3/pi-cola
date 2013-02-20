package edu.osu.picola.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.osu.picola.dataobjects.Course;

public class CourseDAO extends DAO {
	public CourseDAO(Connection conn) {
		super(conn);
	}
	
	/**
	 * inserts a course into the db
	 * @param course the course to be added
	 */
	public void insertCourse(Course course) {
		String insert = "INSERT INTO course (course_id, course_title, course_descr, semester_id)"
			           + " VALUES('"
			           + course.getCourse_id() 
			           + "', '" + course.getCourse_title()
			           + "', '" + course.getCourse_descr()
			           + "', '" + course.getSemester_id() +"')";
		insertDB(insert);
	}
	
	/**
	 * @param user_id the user you want
	 * @return list of all course a student has taken
	 */
	public List<Course> getStudentCourse(int user_id) {
		List<Course> courseEnrolled = new ArrayList<Course>();

		String query = "SELECT * FROM enrolled WHERE user_id = '" + user_id
				+ "'";

		ResultSet rs = queryDB(query);

		try {
			while (rs.next()) {
				courseEnrolled.add(new Course(rs));
			}
		} catch (SQLException e) {
			System.out.println("Failed to load course a student has taken");
			e.printStackTrace();
		}

		return courseEnrolled;
	}

	/**
	 * @param user_id the user you want
	 * @param semester_id the semester you want
	 * @return a list of course the user is enrolled in a given
	 * semester
	 */
	public List<Course> getStudentCourse(int user_id, int semester_id) {
		List<Course> courseEnrolled = new ArrayList<Course>();

		String query = "SELECT * FROM enrolled, WHERE user_id = '" + user_id
				     + "' AND semester_id = '" + semester_id + "'";

		ResultSet rs = queryDB(query);

		try {
			while (rs.next()) {
				courseEnrolled.add(new Course(rs));
			}
		} catch (SQLException e) {
			System.out.println("Failed to load course a student has taken");
			e.printStackTrace();
		}

		return courseEnrolled;
	}

	/**
	 * @param user_id the user you want
	 * @return a list of course taught by a user
	 */
	public List<Course> getCourseTaughtBy(int user_id) {
		List<Course> courseTaught = new ArrayList<Course>();

		String query = "SELECT * FROM teaches WHERE user_id = '" + user_id
				+ "'";
		ResultSet rs = queryDB(query);
		try {
			while (rs.next()) {
				courseTaught.add(new Course(rs));
			}
		} catch (SQLException e) {
			System.out.println("Failed to load course taught by user "
					+ user_id);
			e.printStackTrace();
		}

		return courseTaught;
	}
}
