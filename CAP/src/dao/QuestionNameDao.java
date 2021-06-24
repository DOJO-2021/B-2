package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Questionare;

public class QuestionNameDao {


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
				String sql = "insert into questionnaire values (null, ?, ?, ?, ?)";
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
			List<Questionare> cardList = new ArrayList<Questionare>();

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");

			String sql = "SELECT * FROM QUESTIONNAIRE";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				Questionare card = new Questionare(
				rs.getInt("q_id"),
				rs.getString("q_name"),
				rs.getDate("q_date"),
				rs.getTime("q_time"),
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
