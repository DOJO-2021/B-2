package model;

public class Browsing_Bs {

	private int post_id;
	private int browsing_b_stamp;
	private int count;

	public Browsing_Bs() {
		super();
		this.post_id = 0;
		this.browsing_b_stamp = 0;
		this.count = 0;
	}

	public Browsing_Bs(int post_id, int browsing_b_stamp, int count) {
		super();
		this.post_id = post_id;
		this.browsing_b_stamp = browsing_b_stamp;
		this.count = count;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}



}