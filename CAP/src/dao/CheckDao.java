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

//
//				if (card.getQ_id() != null) {
//					pStmt.setString(1, card.getQ_id());
//				} else {
//					pStmt.setString(1, "null");
//				}
//				if (card.getUser_id() != null) {
//					pStmt.setString(2, card.getUser_id());
//				} else {
//					pStmt.setString(2, "null");
//				}
//				if (card.getC_comprehension_id() != null) {
//					pStmt.setString(3, card.getC_comprehension_id());
//				} else {
//					pStmt.setString(3, "null");
//				}
//				if (card.getC_mental_id() != null) {
//					pStmt.setString(4, card.getC_mental_id());
//				} else {
//					pStmt.setString(4, "null");
//				}
//				if (card.getC_comprehension_text() != null) {
//					pStmt.setString(5, card.getC_comprehension_text());
//				} else {
//					pStmt.setString(5, "null");
//				}
//				if (card.getC_mental_text() != null) {
//					pStmt.setString(6, card.getC_mental_text());
//				} else {
//					pStmt.setString(6, "null");
//				}
//				if (card.getC_date() != null) {
//					pStmt.setString(7, card.getC_date());
//				} else {
//					pStmt.setString(7, "null");
//				}
//				if (card.getC_time() != null) {
//					pStmt.setString(8, card.getC_time());
//				} else {
//					pStmt.setString(8, "null");
//				}



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
		}

		// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
//		public boolean update(Check card) {
//			Connection conn = null;
//			boolean result = false;
//
//			try {
//				// JDBCドライバを読み込む
//				Class.forName("org.h2.Driver");
//
//				// データベースに接続する
//				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleides/workspace/data/simpleBC", "sa", "");
//
//				// SQL文を準備する
//				String sql = "update BC set company=?,"
//						+ "company_hurigana=?,"
//						+ " name=?,"
//						+ " name_hurigana=?,"
//						+ "  department=?,"
//						+ " position=?,"
//						+ " address=?,"
//						+ " phone=?,"
//						+ " mail=?,"
//						+ "remarks=? "
//						+"where id=?";
//				PreparedStatement pStmt = conn.prepareStatement(sql);
//
//				// SQL文を完成させる
//				if (card.getCompany() != null) {
//					pStmt.setString(1, card.getCompany());
//				} else {
//					pStmt.setString(1, "null");
//				}
//				if (card.getCompany_hurigana() != null) {
//					pStmt.setString(2, card.getCompany_hurigana());
//				} else {
//					pStmt.setString(2, "null");
//				}
//				if (card.getName() != null) {
//					pStmt.setString(3, card.getName());
//				} else {
//					pStmt.setString(3, "null");
//				}
//				if (card.getName_hurigana() != null) {
//					pStmt.setString(4, card.getName_hurigana());
//				} else {
//					pStmt.setString(4, "null");
//				}
//				if (card.getDepartment() != null) {
//					pStmt.setString(5, card.getDepartment());
//				} else {
//					pStmt.setString(5, "null");
//				}
//				if (card.getPosition() != null) {
//					pStmt.setString(6, card.getPosition());
//				} else {
//					pStmt.setString(6, "null");
//				}
//				if (card.getAddress() != null) {
//					pStmt.setString(7, card.getAddress());
//				} else {
//					pStmt.setString(7, "null");
//				}
//				if (card.getPhone() != null) {
//					pStmt.setString(8, card.getPhone());
//				} else {
//					pStmt.setString(8, "null");
//				}
//				if (card.getMail() != null) {
//					pStmt.setString(9, card.getMail());
//				} else {
//					pStmt.setString(9, "null");
//				}
//				if (card.getRemarks() != null) {
//					pStmt.setString(10, card.getRemarks());
//				} else {
//					pStmt.setString(10, "null");
//				}
//
//
//				pStmt.setInt(11, card.getId());
//
//				// SQL文を実行する
//				if (pStmt.executeUpdate() == 1) {
//					result = true;
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			} finally {
//				// データベースを切断
//				if (conn != null) {
//					try {
//						conn.close();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//
//			// 結果を返す
//			return result;
//		}


	}


