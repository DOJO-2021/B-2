package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.FaceMark;

public class FaceMarkDao {

	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<FaceMark> facemarkSelectAll(FaceMark param) {
		Connection conn = null;
		List<FaceMark> cardList = new ArrayList<FaceMark>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");

			// SQL文を準備する
			String sql = "select facemark_id, facemark_name from facemark ORDER BY facemark_id ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

//			if (param.getFacemark_name() != null) {
//				pStmt.setString(1, "%" + param.getFacemark_name() + "%");
//			}
//			else {
//				pStmt.setString(1, "%");
//			}


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				FaceMark card = new FaceMark(
					rs.getInt("Facemark_id"),
					rs.getString("Facemark_name")
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
