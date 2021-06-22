package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Check;
import model.Users;

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
				String sql = "insert into check_table values (null,?, ?, ?, ?, ?, ?, ?, ? )";
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
		}

		// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Check> checkSelectAll(Check param) {
			Connection conn = null;
			List<Check> checkList = new ArrayList<Check>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleides/workspace/B-2/CAP/capdb", "sa", "sa");

				// SQL文を準備する
				String sql = "SELECT check_id, q_id, user_id, c_comprehension_id, c_mental_id, c_comprehension_text, c_mental_text, c_date, c_time from check_table ORDER BY check_id";
//						+ " q_id,"
//						+ " user_id,"
//						+ " c_comprehension_id,"
//						+ " c_mental_id,"
//						+ " c_comprehension_text,"
//						+ " c_mental_text,"
//						+ " c_date,"
//						+ " c_time,"
//						+ " WHERE c_comprehension_text LIKE ?AND c_mental_text like ?";
//				System.out.println(sql);
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
//				if (param.getC_comprehension_text() != null) {
//					pStmt.setString(1, "%" + param.getC_comprehension_text() + "%");
//		     	} else {
//					pStmt.setString(1, "%");
//				}
//				if (param.getC_mental_text() != null) {
//					pStmt.setString(2, "%" + param.getC_mental_text() + "%");
//				} else {
//					pStmt.setString(2, "%");
//				}




				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Check card = new Check(
							rs.getInt("check_id"),
							rs.getInt("q_id"),
							rs.getInt("user_id"),
							rs.getInt("c_comprehension_id"),
							rs.getInt(" c_mental_id"),
							rs.getString("c_comprehension_text"),
							rs.getString("c_mental_text"),
							rs.getDate("c_date"),
							rs.getTime("c_time")

							);
					checkList.add(card);
					System.out.println(checkList);

				}
			} catch (SQLException e) {
				e.printStackTrace();
				checkList = null;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				checkList = null;
			} finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						checkList = null;
					}
				}
			}

			// 結果を返す
			return checkList;
		}


		// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
				public boolean NewTableInsert(int q_id, Users param) {
					Connection conn = null;
					boolean result = false;
					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");
						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");
						// SQL文を準備する
						String sql = "insert into Check_Table values (null,?, ?, 0, 0, '', '', '1700-01-01', '00:00:00')";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						// SQL文を完成させる
							pStmt.setInt(1, q_id);
							pStmt.setInt(2, param.getUser_id());
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
				public ArrayList<Users> AllUserSelect(){
					Connection conn = null;
					ArrayList<Users> cardList = new ArrayList<Users>();
				try {
					Class.forName("org.h2.Driver");
					conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");
					String sql = "select user_id from User where user_type=1";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					ResultSet rs = pStmt.executeQuery();
					System.out.println(rs);
					while (rs.next()) {
						Users card = new Users(
						rs.getInt("user_id"));
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
				return cardList;
				}

	}


