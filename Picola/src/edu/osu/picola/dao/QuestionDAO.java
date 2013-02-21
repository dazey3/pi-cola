package edu.osu.picola.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import edu.osu.picola.dataobjects.Question;

public class QuestionDAO extends DAO {

	public QuestionDAO(Connection conn) {
		super(conn);
	}

	// TODO implement Question related SQL
	
	public List<Question> getQuestionByAssignment(int assignment_id) {
		List<Question> questions = new ArrayList<Question>();
		
		String query = "SELECT * FROM";
		
		return questions;
	}
	
	
}
