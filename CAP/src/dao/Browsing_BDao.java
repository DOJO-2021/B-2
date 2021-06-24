package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Browsing_B;
import model.Browsing_Bs;

public class Browsing_BDao {

	public List<Browsing_B> stampSelectAll(Browsing_B param){
		Connection conn = null;
		List<Browsing_B> browsing_bList = new ArrayList<Browsing_B>();

	try {
		Class.forName("org.h2.Driver");
		conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");

		String sql = "select browsing_b_id, post_id, browsing_b_stamp, user_id from Browsing_B ORDER BY browsing_b_id";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		ResultSet rs = pStmt.executeQuery();
		while (rs.next()) {
			Browsing_B card = new Browsing_B(
			rs.getInt("browsing_b_id"),
			rs.getInt("post_id"),
			rs.getInt("browsing_b_stamp"),
			rs.getInt("user_id")
			);
			browsing_bList.add(card);
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
		browsing_bList = null;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		browsing_bList = null;
	}
	finally {
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				browsing_bList = null;
			}
		}
	}
	return browsing_bList;
}

	public List<Browsing_Bs> CountStamp(){
		Connection conn = null;
		List<Browsing_Bs> S_CountList = new ArrayList<Browsing_Bs>();

	try {
		Class.forName("org.h2.Driver");
		conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");

		String sql = "select post_id,  browsing_b_stamp, count(browsing_b_ID) from browsing_b  group by post_id, browsing_b_stamp ";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		ResultSet rs = pStmt.executeQuery();
		while (rs.next()) {
			Browsing_Bs card = new Browsing_Bs(
					rs.getInt("post_id"),
					rs.getInt("browsing_b_stamp"),
					rs.getInt("count(browsing_b_ID)")
			);
			S_CountList.add(card);
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
		S_CountList = null;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		S_CountList = null;
	}
	finally {
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				S_CountList = null;
			}
		}
	}
	return S_CountList;

	}

	public boolean StampInsert(int post_id, int browsing_b_stamp, int  user_id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");
			// SQL文を準備する
			String sql = "insert into browsing_b values (null,?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
				pStmt.setInt(1, post_id);
				pStmt.setInt(2, browsing_b_stamp);
				pStmt.setInt(3, user_id);

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


	}
