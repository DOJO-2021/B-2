package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class IdDao {

	// 引数paramで検索項目を指定し、IDを返す
	public int acquire(User param) {
		Connection conn = null;
		int card = 0;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");

			// SQL文を準備する
			String sql = "select user_id, user_l_name, user_f_name, user_password, secret_id, user_answer, user_type from User where user_l_name like ? and user_f_name like ? and user_password like ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (param.getUser_l_name() != null) {
				pStmt.setString(1, "%" + param.getUser_l_name() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getUser_f_name() != null) {
				pStmt.setString(2, "%" + param.getUser_f_name() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getUser_password() != null) {
				pStmt.setString(3, "%" + param.getUser_password() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			rs.next();
			card = rs.getInt("User_id");

		}

		catch (SQLException e) {
			e.printStackTrace();
			card = 0;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			card = 0;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					card = 0;
				}
			}
		}

		// 結果を返す
		return card;
	}

}
