package model;
import java.sql.Date;
import java.sql.Time;

public class Questionare {






		private int q_id ;
		private String q_name ;
		private Date q_date ;
		private Time q_time ;
		private int user_id ;


		//引数がないコンストラクタ
		public Questionare() {}

		//引数があるコンストラクタ
		public Questionare(int q_id, String q_name, Date q_date, Time q_time, int user_id) {
			this.q_id = q_id;
			this.q_name = q_name;
			this.q_date = q_date;
			this.q_time = q_time;
			this.user_id = user_id;


		}

		public int getQ_id() {
			return q_id;
		}

		public void setQ_id(int q_id) {
			this.q_id = q_id;
		}

		public String getQ_name() {
			return q_name;
		}

		public void setQ_name(String q_name) {
			this.q_name = q_name;
		}

		public Date getQ_date() {
			return q_date;
		}

		public void setQ_date(Date q_date) {
			this.q_date = q_date;
		}

		public Time getQ_time() {
			return q_time;
		}

		public void setQ_time(Time q_time) {
			this.q_time = q_time;
		}

		public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

}
