package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.FaceMarks;

public class FaceCalculateDao {

//	public static void main(String[] args) {
//		System.out.println("「good,soso,bad」=" + faceCalculate());
//	}

	// good,soso,badの数を計算してリストにして返す
	public List<FaceMarks> faceCalculate() {
		Connection conn = null;
		List<FaceMarks> cardList = new ArrayList<FaceMarks>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");

			// SQL文を準備する
			String sql = "select c_mental_id,count(c_mental_id) from CHECK_TABLE group by C_MENTAL_ID";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
					FaceMarks card = new FaceMarks(
						rs.getInt("C_MENTAL_ID"),
						rs.getInt("C_MENTAL_ID"),
						rs.getInt("C_MENTAL_ID")
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
