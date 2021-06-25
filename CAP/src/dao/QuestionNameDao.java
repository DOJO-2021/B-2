package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.QuestionName;
import model.Questionare;

public class QuestionNameDao{




	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Questionare card) {
		java.sql.Connection conn = null;
		boolean result = false;


			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");

				// SQL文を準備する
				String sql = "insert into questionnaire values (null, ?, ?, ?, ?)";
				PreparedStatement pStmt = ((java.sql.Connection) conn).prepareStatement(sql);

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

	// 引数paramで検索項目を指定し、検索結果のリストを返す
			public List<QuestionName> Q_NAME(QuestionName param) {
				Connection conn = null;
				List<QuestionName> q_nameList = new ArrayList<QuestionName>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");

					// SQL文を準備する
					String sql3 = "SELECT * FROM QUESTIONNAIRE ";


					PreparedStatement pStmt = conn.prepareStatement(sql3);

					// SQL文を完成させる
//					if (param.getQ_id() != null) {
//						pStmt.setInt(1, "%" + param.getQ_id() + "%");
//			     	} else {
//						pStmt.setInt(1, "%");
//					}
//					if (param.getC_mental_text() != null) {
//						pStmt.setString(2, "%" + param.getC_mental_text() + "%");
//					} else {
//						pStmt.setString(2, "%");
//					}
//



					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						QuestionName card = new QuestionName(
								rs.getInt("q_id"),
								rs.getString("q_name"),
								rs.getDate("q_date"),
								rs.getTime("q_time"),
								rs.getInt("user_id")
								);
						q_nameList.add(card);
						System.out.println(q_nameList);

					}
				} catch (SQLException e) {
					e.printStackTrace();
					q_nameList = null;
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					q_nameList = null;
				} finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
							e.printStackTrace();
							q_nameList = null;
						}
					}
				}

				// 結果を返す
				return q_nameList;
			}





	//アンケートの内容からオートインクリメントのIDを取得
		public int q_idSearch(Questionare param){
			Connection conn = null;
			int card = 0;

			try {
				Class.forName("org.h2.Driver");
				conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");
				String sql1 = "select q_id from QUESTIONNAIRE where q_name=? and q_date=? and q_time=? and user_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql1);
				pStmt.setString(1, param.getQ_name());
				pStmt.setDate(2, param.getQ_date());
				pStmt.setTime(3, param.getQ_time());
				pStmt.setInt(4, param.getUser_id());

				ResultSet rs1 = pStmt.executeQuery();
				rs1.next();
				card = rs1.getInt("q_id");

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
			return card;
		}

		//IDから内容を取得
		public  List<Questionare> NewQ_Data(){
			Connection conn = null;
			List<Questionare> q_nameList = new ArrayList<Questionare>();

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");

			String sql2 = "SELECT * FROM QUESTIONNAIRE";
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);

			ResultSet rs = pStmt2.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				Questionare card = new Questionare(
				rs.getInt("q_id"),
				rs.getString("q_name"),
				rs.getDate("q_date"),
				rs.getTime("q_time"),
				rs.getInt("user_id"));
				q_nameList.add(card);
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
			q_nameList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			q_nameList = null;
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					q_nameList = null;
				}
			}
		}
		return q_nameList;

		}

}
