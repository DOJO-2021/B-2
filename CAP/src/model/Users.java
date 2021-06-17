package model;

import java.io.Serializable;

public class Users  implements Serializable {
	private String user_id;	// ログイン時のID
	private int user_type;

	public Users(String user_id, int user_type) {
		super();
		this.user_id = user_id;
		this.user_type = user_type;
	}


	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getUser_type() {
		return user_type;
	}
	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}

	}
