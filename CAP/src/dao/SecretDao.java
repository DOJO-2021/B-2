package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class SecretDao {
	// ログインできるならtrueを返す
	public boolean isIdOK(String l_name, String f_name, String questions, String answer) {
		Connection conn = null; // コネクションオブジェクト(接続できたかどうか)　お決まり
		boolean pwResult = false;

		try {
			// ①JDBCドライバを読み込む　お決まり
			Class.forName("org.h2.Driver");

			// ②データベースに接続する
			// connがNULLでなければ、ログインできている
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-2/CAP/capdb", "sa", "sa");

			// ③SELECT文を準備する
			String sql = "select count(*) from user where user_l_name = ? and user_f_name = ? and secret_id = ? and user_answer = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);  // 無害化
			pStmt.setString(1, l_name); // ？の1番目の１
			pStmt.setString(2, f_name);
			pStmt.setString(3, questions);
			pStmt.setString(4, answer);

			// ④SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ⑤ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				pwResult = true;
			}
		} // 例外はログインできない
		catch (SQLException e) {
			e.printStackTrace(); // 例外情報を画面に表示
			pwResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			pwResult = false;
		}
		finally {
			// 例外が発生してもしなくても、共通の一番最後に行う処理(終了処理)
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					pwResult = false;
				}
			}
		}

		// 結果を返す
		return pwResult;
	}

	// セッションスコープのuser_idからアカウント情報を検索
	public List<User> selectById(User param) {
		Connection conn = null;
		List<User> cardList = new ArrayList<User>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");

			// SQL文を準備する
			String sql = "select user_id, user_l_name, user_f_name, user_password, secret_id, user_answer, user_type from User where user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			pStmt.setInt(1, param.getUser_id());


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				 User card = new User(
					rs.getInt("User_id"),
					rs.getString("User_l_name"),
					rs.getString("User_f_name"),
					rs.getString("User_password"),
					rs.getString("Secret_id"),
					rs.getString("User_answer"),
					rs.getInt("User_type")
					);

				cardList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		// 結果を返す
		return cardList;
	}
}
