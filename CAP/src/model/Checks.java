package model;

public class Checks {


	private int check_id ;
	private int q_id ;
	private int user_id ;
	private int c_comprehension_id ;
	private int c_mental_id ;
	private String c_comprehension_text ;
	private String c_mental_text ;
	private String c_date ;
	private String c_time ;

	//引数がないコンストラクタ
	public Checks() {}

	//引数があるコンストラクタ
	public Checks(int check_id, int q_id, int user_id, int c_comprehension_id, int c_mental_id, String c_comprehension_text,
			String c_mental_text, String c_date, String c_time) {
		this.check_id = check_id;
		this.q_id = q_id;
		this.user_id = user_id;
		this.c_comprehension_id = c_comprehension_id;
		this.c_mental_id = c_mental_id;
		this.c_comprehension_text = c_comprehension_text;
		this.c_mental_text = c_mental_text;
		this.c_date  = c_date ;
		this.c_time = c_time;
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

	public String getC_date() {
		return c_date;
	}

	public void setC_date(String c_date) {
		this.c_date = c_date;
	}

	public String getC_time() {
		return c_time;
	}

	public void setC_time(String c_time) {
		this.c_time = c_time;
	}
}