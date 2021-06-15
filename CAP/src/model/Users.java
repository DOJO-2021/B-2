package model;

import java.io.Serializable;

public class Users  implements Serializable {
		private String user_id;	// ログイン時のID

		public Users() {
			this(null);
		}

		public Users(String user_id) {
			this.user_id = user_id;
		}

		public String getId() {
			return user_id;
		}

		public void setUserId(String user_id) {
			this.user_id = user_id;
		}
	}
