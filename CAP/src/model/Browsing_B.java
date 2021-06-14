package model;

public class Browsing_B {

	private int browsing_b_id;
	private int post_id;
	private int browsing_b_stamp;
	private int user_id;

	public Browsing_B(int browsing_b_id, int post_id, int browsing_b_stamp, int user_id) {
		super();
		this.browsing_b_id = browsing_b_id;
		this.post_id = post_id;
		this.browsing_b_stamp = browsing_b_stamp;
		this.user_id = user_id;
	}

	public Browsing_B() {
		super();
		this.browsing_b_id = 0;
		this.post_id = 0;
		this.browsing_b_stamp = 0;
		this.user_id = 0;
	}

	public int getBrowsing_b_id() {
		return browsing_b_id;
	}
	public void setBrowsing_b_id(int browsing_b_id) {
		this.browsing_b_id = browsing_b_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getBrowsing_b_stamp() {
		return browsing_b_stamp;
	}
	public void setBrowsing_b_stamp(int browsing_b_stamp) {
		this.browsing_b_stamp = browsing_b_stamp;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


}
