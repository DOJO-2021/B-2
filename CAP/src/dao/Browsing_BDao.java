package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Browsing_B;

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



}
