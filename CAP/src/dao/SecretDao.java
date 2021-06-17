package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			String sql = "select count(*) from user where user_l_name = ? and user_f_name = ? and user_questions = ? and user_answer = ?";
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
}
