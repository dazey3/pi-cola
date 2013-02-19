package edu.osu.picola.dataobjects;

import java.sql.Date;

public class Post {
	private int post_id;
	private String post_text;
	private Date post_time;
	private boolean MP_bit;
	private boolean BP_bit;
	private boolean summary_bit;
	private boolean is_flagged;
	private int user_id;
	private int group_id;
	
	public Post() {
		post_id = 0;
		post_text = "";
		post_time = null;
		MP_bit = false;
		BP_bit = false;
		summary_bit = false;
		is_flagged = false;
		user_id = 0;
		group_id = 0;
	}
	
	public Post(int post_id, String post_text, Date post_time, boolean mp_bit, boolean bp_bit, boolean summary_bit,
			boolean is_flagged, int user_id, int group_id) {
		this.post_id = post_id;
		this.post_text = post_text;
		this.post_time = post_time;
		this.MP_bit = mp_bit;
		this.BP_bit = bp_bit;
		this.summary_bit = summary_bit;
		this.is_flagged = is_flagged;
		this.user_id = user_id;
		this.group_id = group_id;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getPost_text() {
		return post_text;
	}

	public void setPost_text(String post_text) {
		this.post_text = post_text;
	}

	public Date getPost_time() {
		return post_time;
	}

	public void setPost_time(Date post_time) {
		this.post_time = post_time;
	}

	public boolean isMP_bit() {
		return MP_bit;
	}

	public void setMP_bit(boolean mP_bit) {
		MP_bit = mP_bit;
	}

	public boolean isBP_bit() {
		return BP_bit;
	}

	public void setBP_bit(boolean bP_bit) {
			BP_bit = bP_bit;
	}

	public boolean isSummary_bit() {
		return summary_bit;
	}

	public void setSummary_bit(boolean summary_bit) {
		this.summary_bit = summary_bit;
	}

	public boolean isIs_flagged() {
		return is_flagged;
	}

	public void setIs_flagged(boolean is_flagged) {
		this.is_flagged = is_flagged;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	
	
}
