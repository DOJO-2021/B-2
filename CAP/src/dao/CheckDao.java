package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Check;

public class CheckDao {


		// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(Check card) {
			Connection conn = null;
			boolean result = false;



			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleides/workspace/B-2/CAP/capdb", "sa", "sa");

				// SQL文を準備する
				String sql = "insert into Check values (null,?, ?, ?, ?, ?, ?, ?, ? )";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる


//				if (card.getQ_id() != 0) {
					pStmt.setInt(1, card.getQ_id());
//				} else {
//					pStmt.setString(1, "null");
//				}
//				if (card.getUser_id() != 0) {
					pStmt.setInt(2, card.getUser_id());
//				} else {
//					pStmt.setString(2, "null");
//				}
//				if (card.getC_comprehension_id() != 0) {
					pStmt.setInt(3, card.getC_comprehension_id());
//				} else {
//					pStmt.setString(3, "0");
//				}
//				if (card.getC_mental_id() != 0) {
					pStmt.setInt(4, card.getC_mental_id());
//				} else {
//					pStmt.setString(4, "null");
//				}
				if (card.getC_comprehension_text() != null) {
					pStmt.setString(5, card.getC_comprehension_text());
				} else {
					pStmt.setString(5, "null");
				}
				if (card.getC_mental_text() != null) {
					pStmt.setString(6, card.getC_mental_text());
				} else {
					pStmt.setString(6, "null");
				}
				if (card.getC_date() != null) {
					pStmt.setDate(7, card.getC_date());
				} else {
					pStmt.setString(7, "null");
				}
				if (card.getC_time() != null) {
					pStmt.setTime(8, card.getC_time());
				} else {
					pStmt.setString(8, "null");
				}



				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
//		}

		// 引数paramで検索項目を指定し、検索結果のリストを返す
//		public List<Check> select(Check param) {
//			Connection conn = null;
//			List<Check> cardList = new ArrayList<Check>();
//
//			try {
//				// JDBCドライバを読み込む
//				Class.forName("org.h2.Driver");
//
//				// データベースに接続する
//				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleides/workspace/B-2/CAP/capdb", "sa", "sa");

				// SQL文を準備する
//				String sql = "SELECT check_id, q_id, user_id, c_comprehension_id, c_mental_id, c_comprehension_text, c_mental_text, c_date, c_time from check_table"
//						+ " q_id,"
//						+ " user_id,"
//						+ " c_comprehension_id,"
//						+ " c_mental_id,"
//						+ " c_comprehension_text,"
//						+ " c_mental_text,"
//						+ " c_date,"
//						+ " c_time,"
//						+ " WHERE company LIKE ? AND company_hurigana like ? AND name LIKE ? AND name_hurigana like ? AND address LIKE ?";
//				System.out.println(sql);
//				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
//				if (param.getCompany() != null) {
//					pStmt.setString(1, "%" + param.getCompany() + "%");
//				} else {
//					pStmt.setString(1, "%");
//				}
//				if (param.getCompany_hurigana() != null) {
//					pStmt.setString(2, "%" + param.getCompany_hurigana() + "%");
//				} else {
//					pStmt.setString(2, "%");
//				}
//				if (param.getName() != null) {
//					pStmt.setString(3, "%" + param.getName() + "%");
//				} else {
//					pStmt.setString(3, "%");
//				}
//				if (param.getName_hurigana() != null) {
//					pStmt.setString(4, "%" + param.getName_hurigana() + "%");
//				} else {
//					pStmt.setString(4, "%");
//				}
//
//				if (param.getAddress() != null) {
//					pStmt.setString(5, "%" + param.getAddress() + "%");
//				} else {
//					pStmt.setString(5, "%");
//				}
//
//
//
//				// SQL文を実行し、結果表を取得する
//				ResultSet rs = pStmt.executeQuery();
//
//				// 結果表をコレクションにコピーする
//				while (rs.next()) {
//					Bc card = new Bc(
//							rs.getInt("id"),
//							rs.getString("company"),
//							rs.getString("company_hurigana"),
//							rs.getString("name"),
//							rs.getString("name_hurigana"),
//							rs.getString("department"),
//							rs.getString("position"),
//							rs.getString("address"),
//							rs.getString("phone"),
//							rs.getString("mail"),
//							rs.getString("remarks")
//							);
//					cardList.add(card);
//
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//				cardList = null;
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//				cardList = null;
//			} finally {
//				// データベースを切断
//				if (conn != null) {
//					try {
//						conn.close();
//					} catch (SQLException e) {
//						e.printStackTrace();
//						cardList = null;
//					}
//				}
//			}
//
//			// 結果を返す
//			return cardList;
//		}

	}
}

