package model;

import java.sql.Date;
import java.sql.Time;

public class AllData {
	private int check_id ;
	private int q_id ;
	private int user_id ;
	private int c_comprehension_id ;
	private int c_mental_id ;
	private String c_comprehension_text ;
	private String c_mental_text ;
	private Date c_date ;
	private Time c_time ;
	private String q_name;
	private String l_name;
	private String f_name;

	public AllData() {
		super();
		this.check_id = 0;
		this.q_id = 0;
		this.user_id = 0;
		this.c_comprehension_id = 0;
		this.c_mental_id = 0;
		this.c_comprehension_text = "";
		this.c_mental_text = "";
		this.c_date = null;
		this.c_time = null;
		this.q_name = "";
		this.l_name = "";
		this.f_name = "";
	}






	public AllData(int check_id, int q_id, int user_id, int c_comprehension_id, int c_mental_id,
			String c_comprehension_text, String c_mental_text, Date c_date, Time c_time, String q_name, String l_name,
			String f_name) {
		super();
		this.check_id = check_id;
		this.q_id = q_id;
		this.user_id = user_id;
		this.c_comprehension_id = c_comprehension_id;
		this.c_mental_id = c_mental_id;
		this.c_comprehension_text = c_comprehension_text;
		this.c_mental_text = c_mental_text;
		this.c_date = c_date;
		this.c_time = c_time;
		this.q_name = q_name;
		this.l_name = l_name;
		this.f_name = f_name;
	}

	public int getCheck_id() {
		return check_id;
	}
	public void setCheck_id(int check_id) {
		this.check_id = check_id;
	}
	public int getQ_id() {
		return q_id;
	}
	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getC_comprehension_id() {
		return c_comprehension_id;
	}
	public void setC_comprehension_id(int c_comprehension_id) {
		this.c_comprehension_id = c_comprehension_id;
	}
	public int getC_mental_id() {
		return c_mental_id;
	}
	public void setC_mental_id(int c_mental_id) {
		this.c_mental_id = c_mental_id;
	}
	public String getC_comprehension_text() {
		return c_comprehension_text;
	}
	public void setC_comprehension_text(String c_comprehension_text) {
		this.c_comprehension_text = c_comprehension_text;
	}
	public String getC_mental_text() {
		return c_mental_text;
	}
	public void setC_mental_text(String c_mental_text) {
		this.c_mental_text = c_mental_text;
	}
	public Date getC_date() {
		return c_date;
	}
	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}
	public Time getC_time() {
		return c_time;
	}
	public void setC_time(Time c_time) {
		this.c_time = c_time;
	}
	public String getQ_name() {
		return q_name;
	}
	public void setQ_name(String q_name) {
		this.q_name = q_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}


}
