package model;

import java.io.Serializable;

public class User implements Serializable {
	private int user_id;
	private String user_l_name;
	private String user_f_name;
	private String user_password;
	private String user_questions;
	private String user_answer;
	private String user_word_s;
	private String user_word_t;
	private int user_type;

	//引数があるコンストラクタ
	public User(int user_id, String user_l_name, String user_f_name, String user_password, String user_questions,
		String user_answer, String user_word_s, String user_word_t, int user_type) {
	super();
	this.user_id = user_id;
	this.user_l_name = user_l_name;
	this.user_f_name = user_f_name;
	this.user_password = user_password;
	this.user_questions = user_questions;
	this.user_answer = user_answer;
	this.user_word_s = user_word_s;
	this.user_word_t = user_word_t;
	this.user_type = user_type;
	}
	//引数がないコンストラクタ（デフォルトコンストラクタ）
	public User(){
		super();
		this.user_id = 0;
		this.user_l_name = "";
		this.user_f_name = "";
		this.user_password = "";
		this.user_questions = "";
		this.user_answer = "";
		this.user_word_s = "";
		this.user_word_t = "";
		this.user_type = 0;
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
	public String getUser_questions() {
		return user_questions;
	}
	public void setUser_questions(String user_questions) {
		this.user_questions = user_questions;
	}
	public String getUser_answer() {
		return user_answer;
	}
	public void setUser_answer(String user_answer) {
		this.user_answer = user_answer;
	}
	public String getUser_word_s() {
		return user_word_s;
	}
	public void setUser_word_s(String user_word_s) {
		this.user_word_s = user_word_s;
	}
	public String getUser_word_t() {
		return user_word_t;
	}
	public void setUser_word_t(String user_word_t) {
		this.user_word_t = user_word_t;
	}
	public int getUser_type() {
		return user_type;
	}
	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}

	}