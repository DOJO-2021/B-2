package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDao {
// 引数paramで検索項目を指定し、検索結果のリストを返す
public List<User> select(User param) {
	Connection conn = null;
	List<User> cardList = new ArrayList<User>();

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


// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
public boolean insert(User card) {
	Connection conn = null;
	boolean result = false;


		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");

			// SQL文を準備する
			String sql = "insert into User values (null, ?, ?, ?, ?, ?, ?)";
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
			if (card.getSecret_id() != null) {
				pStmt.setString(4, card.getSecret_id());
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
				pStmt.setInt(6, card.getUser_type());



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

// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
public boolean update(User card) {
	Connection conn = null;
	boolean result = false;

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");

		// SQL文を準備する
		String sql = "update User set User_l_name=?, User_f_name=?, User_password=?, Secret_id=?, User_answer=?, User_type=? where user_id=?";
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
			if (card.getSecret_id() != null) {
				pStmt.setString(4, card.getSecret_id());
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
				pStmt.setInt(6, card.getUser_type());


				pStmt.setInt(7, card.getUser_id());


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

//ログイン処理
	// ログインできるならtrueを返す
	public boolean isLoginOK(String user_l_name, String user_f_name, String user_password) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");

			// SELECT文を準備する
			String sql = "select count(*) from User where user_l_name = ? and user_f_name = ? and user_password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user_l_name);
			pStmt.setString(2, user_f_name);
			pStmt.setString(3, user_password);//1、2は？マークの位置のこと

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				loginResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}
}

