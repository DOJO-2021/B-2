package model;

import java.sql.Date;
import java.sql.Time;

public class Post {

	private int post_id;
	private int user_id;
	private String post_text;
	private int genre_id;
	private Date post_date;
	private Time post_time;

	public Post(int post_id, int user_id, String post_text, int genre_id, Date post_date, Time post_time) {
		super();
		this.post_id = post_id;
		this.user_id = user_id;
		this.post_text = post_text;
		this.genre_id = genre_id;
		this.post_date = post_date;
		this.post_time = post_time;
	}

	public Post() {
		super();
		this.post_id =0;
		this.user_id = 0;
		this.post_text = "";
		this.genre_id = 0;
		this.post_date = null;
		this.post_time = null;
	}

	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getPost_text() {
		return post_text;
	}
	public void setPost_text(String post_text) {
		this.post_text = post_text;
	}
	public int getGenre_id() {
		return genre_id;
	}
	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	public Time getPost_time() {
		return post_time;
	}
	public void setPost_time(Time post_time) {
		this.post_time = post_time;
	}

}
