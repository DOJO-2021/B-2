package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

//public class UserDAO {
//	// 引数paramで検索項目を指定し、検索結果のリストを返す
//	public List<User> select(User param) {
//		Connection conn = null;
//		List<User> cardList = new ArrayList<User>();
//
//		try {
//			// JDBCドライバを読み込む
//			Class.forName("org.h2.Driver");
//
//			// データベースに接続する
//			conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "");
//
//			// SQL文を準備する
//			String sql = "select user_id, user_l_name, user_f_name, user_password, user_questions, user_answer, user_word_s, user_word_t, user_type from User where user_id like ? and user_l_name like ? and user_f_name like ? and  like ?";
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//
//			// SQL文を完成させる
//			 if(param.getName() != null) {
//				pStmt.setString(1, "%" + param.getName() + "%");
//			}
//			else {
//				pStmt.setString(1, "%");
//			}
//			if (param.getName_kana() != null) {
//				pStmt.setString(2, "%" + param.getName_kana() + "%");
//			}
//			else {
//				pStmt.setString(2, "%");
//			}
//			if (param.getCompany() != null) {
//				pStmt.setString(3, "%" + param.getCompany() + "%");
//			}
//			else {
//				pStmt.setString(3, "%");
//			}
//			if (param.getAddress() != null) {
//				pStmt.setString(4, "%" + param.getAddress() + "%");
//			}
//			else {
//				pStmt.setString(4, "%");
//			}
//
//			// SQL文を実行し、結果表を取得する
//			ResultSet rs = pStmt.executeQuery();
//
//			// 結果表をコレクションにコピーする
//			while (rs.next()) {
//				Bc card = new Bc(
//					rs.getInt("id"),
//					rs.getString("name"),
//					rs.getString("name_kana"),
//					rs.getString("company"),
//					rs.getString("department"),
//					rs.getString("zipcode"),
//					rs.getString("address"),
//					rs.getString("call"),
//					rs.getString("mail"),
//					rs.getString("others")
//					);
//
//				cardList.add(card);
//			}
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//			cardList = null;
//		}
//		catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			cardList = null;
//		}
//		finally {
//			// データベースを切断
//			if (conn != null) {
//				try {
//					conn.close();
//				}
//				catch (SQLException e) {
//					e.printStackTrace();
//					cardList = null;
//				}
//			}
//		}
//
//		// 結果を返す
//		return cardList;
//	}
while (rs.next()) {
	Bc card = new Bc(
		rs.getInt("id"),
		rs.getString("name"),
		rs.getString("name_kana"),
		rs.getString("company"),
		rs.getString("department"),
		rs.getString("zipcode"),
		rs.getString("address"),
		rs.getString("call"),
		rs.getString("mail"),
		rs.getString("others")
		);

	cardList.add(card);

	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(User card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "");

			// SQL文を準備する
			String sql = "insert into User values (null, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getUser_l_name() != null) {
				pStmt.setString(1, card.getUser_l_name());
			}
			else {
				pStmt.setString(1, "null");
			}
			if (card.getUser_f_name() != null) {
				pStmt.setString(2, card.getUser_f_name());
			}
			else {
				pStmt.setString(2, "null");
			}
			if (card.getUser_password() != null) {
				pStmt.setString(3, card.getUser_password());
			}
			else {
				pStmt.setString(3, "null");
			}
			if (card.getUser_questions() != null) {
				pStmt.setString(4, card.getUser_questions());
			}
			else {
				pStmt.setString(4, "null");
			}
			if (card.getUser_answer() != null) {
				pStmt.setString(5, card.getUser_answer());
			}
			else {
				pStmt.setString(5, "null");
			}
			if (card.User_word_s() != null) {
				pStmt.setString(6, card.User_word_s());
			}
			else {
				pStmt.setString(6, "null");
			}
			if (card.getUser_word_t() != null) {
				pStmt.setString(7, card.getUser_word_t());
			}
			else {
				pStmt.setString(7, "null");
			}
			if (card.getUser_type() != null) {
				pStmt.setInt(8, card.User_type());
			}
			else {
				pStmt.setInt(8, "null");
			}


			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}
}
