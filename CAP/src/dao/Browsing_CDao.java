package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Browsing_C;

public class Browsing_CDao {

	public List<Browsing_C> commentSelectAll(Browsing_C param){
		Connection conn = null;
		List<Browsing_C> commentList = new ArrayList<Browsing_C>();

	try {
		Class.forName("org.h2.Driver");
		conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");

		String sql = "select browsing_c_id, post_id, browsing_c_comment, browsing_c_date, browsing_c_time, user_id from Browsing_C ORDER BY browsing_c_id";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		ResultSet rs = pStmt.executeQuery();
		while (rs.next()) {
			Browsing_C card = new Browsing_C(
			rs.getInt("browsing_c_id"),
			rs.getInt("post_id"),
			rs.getString("browsing_c_comment"),
			rs.getDate("browsing_c_date"),
			rs.getTime("browsing_c_time"),
			rs.getInt("user_id")
			);
			commentList.add(card);
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
		commentList = null;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		commentList = null;
	}
	finally {
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				commentList = null;
			}
		}
	}
	return commentList;
}

	public boolean commentInsert(Browsing_C card) {
		Connection conn = null;
		boolean result = false;

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C://pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");
			String sql = "insert into  Browsing_C(browsing_c_id, post_id, browsing_c_comment, browsing_c_date, browsing_c_time, user_id) values (null, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (card.getPost_id() != 0) {
				pStmt.setInt(1, card.getPost_id());
			}
			else {
				pStmt.setInt(1, 0);
			}
			if (card.getBrowsing_c_comment() != null) {
				pStmt.setString(2, card.getBrowsing_c_comment());
			}
			else {
				pStmt.setString(2, null);
			}
			if (card.getBrowsing_c_date() != null) {
				pStmt.setDate(3, card.getBrowsing_c_date());
			}
			else {
				pStmt.setString(3, null);
			}
			if (card.getBrowsing_c_time() != null) {
				pStmt.setTime(4, card.getBrowsing_c_time());
			}
			else {
				pStmt.setString(4, null);
			}
			if (card.getUser_id() != 0) {
				pStmt.setInt(5,card.getUser_id());
			}
			else {
				pStmt.setInt(5, 0);
			}

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
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

}
