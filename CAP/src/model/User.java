package model;

import java.io.Serializable;

public class User implements Serializable {
	private int user_id;
	private String user_l_name;
	private String user_f_name;
	private String user_password;
	private String secret_id;
	private String user_answer;
	private int user_type;

	//引数があるコンストラクタ
	public User(int user_id, String user_l_name, String user_f_name, String user_password, String secret_id,
		String user_answer, int user_type) {
	super();
	this.user_id = user_id;
	this.user_l_name = user_l_name;
	this.user_f_name = user_f_name;
	this.user_password = user_password;
	this.secret_id = secret_id;
	this.user_answer = user_answer;
	this.user_type = user_type;
	}
	//引数がないコンストラクタ（デフォルトコンストラクタ）
	public User(){
		super();
		this.user_id = 0;
		this.user_l_name = "";
		this.user_f_name = "";
		this.user_password = "";
		this.secret_id = "";
		this.user_answer = "";
		this.user_type = 1;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_l_name() {
		return user_l_name;
	}
	public void setUser_l_name(String user_l_name) {
		this.user_l_name = user_l_name;
	}
	public String getUser_f_name() {
		return user_f_name;
	}
	public void setUser_f_name(String user_f_name) {
		this.user_f_name = user_f_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getSecret_id() {
		return secret_id;
	}
	public void setSecret_id(String secret_id) {
		this.secret_id = secret_id;
	}
	public String getUser_answer() {
		return user_answer;
	}
	public void setUser_answer(String user_answer) {
		this.user_answer = user_answer;
	}

	public int getUser_type() {
		return user_type;
	}
	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}

	}