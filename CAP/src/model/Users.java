package model;

import java.io.Serializable;

public class Users  implements Serializable {
	private int user_id;	// ログイン時のID

	public Users(int user_id) {
		super();
		this.user_id = user_id;
	}


	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	}
