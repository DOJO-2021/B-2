package model;

import java.sql.Date;
import java.sql.Time;

public class Browsing_C {

	private int browsing_c_id;
	private int post_id;
	private String browsing_c_comment;
	private Date browsing_c_date;
	private Time browsing_c_time;
	private int user_id;

	public Browsing_C(int browsing_c_id, int post_id, String browsing_c_comment, Date browsing_c_date,
			Time browsing_c_time, int user_id) {
		super();
		this.browsing_c_id = browsing_c_id;
		this.post_id = post_id;
		this.browsing_c_comment = browsing_c_comment;
		this.browsing_c_date = browsing_c_date;
		this.browsing_c_time = browsing_c_time;
		this.user_id = user_id;
	}

	public Browsing_C() {
		super();
		this.browsing_c_id = 0;
		this.post_id = 0;
		this.browsing_c_comment = "";
		this.browsing_c_date = null;
		this.browsing_c_time = null;
		this.user_id = 0;
	}

	public int getBrowsing_c_id() {
		return browsing_c_id;
	}

	public void setBrowsing_c_id(int browsing_c_id) {
		this.browsing_c_id = browsing_c_id;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getBrowsing_c_comment() {
		return browsing_c_comment;
	}

	public void setBrowsing_c_comment(String browsing_c_comment) {
		this.browsing_c_comment = browsing_c_comment;
	}

	public Date getBrowsing_c_date() {
		return browsing_c_date;
	}

	public void setBrowsing_c_date(Date browsing_c_date) {
		this.browsing_c_date = browsing_c_date;
	}

	public Time getBrowsing_c_time() {
		return browsing_c_time;
	}

	public void setBrowsing_c_time(Time browsing_c_time) {
		this.browsing_c_time = browsing_c_time;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
