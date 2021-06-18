package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Questionare;

public class QuestionareDao {


	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Questionare card) {
		Connection conn = null;
		boolean result = false;


			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");

				// SQL文を準備する
				String sql = "insert into User values (null, ?, ?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getQ_name() != null) {
					pStmt.setString(1, card.getQ_name());
				}
				else {
					pStmt.setString(1, "null");
				}
				if (card.getQ_date() != null) {
					pStmt.setDate(2, card.getQ_date());
				}
				else {
					pStmt.setString(2, "null");
				}
				if (card.getQ_time() != null) {
					pStmt.setTime(3, card.getQ_time());
				}
				else {
					pStmt.setString(3, "null");
				}
//				if (card.getUser_id() != null) {
					pStmt.setInt(4, card.getUser_id());
//				}
//				else {
//					pStmt.setString(4, "null");
//				}



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
