package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Post;

public class PostDao {

	public List<Post> postSelectAll(Post param){
		Connection conn = null;
		List<Post> postList = new ArrayList<Post>();

	try {
		Class.forName("org.h2.Driver");
		conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");

		String sql = "select post_id, user_id, post_text, genre_id, post_date, post_time from post ORDER BY post_id";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		ResultSet rs = pStmt.executeQuery();
		while (rs.next()) {
			Post card = new Post(
			rs.getInt("post_id"),
			rs.getInt("user_id"),
			rs.getString("post_text"),
			rs.getInt("genre_id"),
			rs.getDate("post_date"),
			rs.getTime("post_time")
			);
			postList.add(card);
			System.out.println(postList);
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
		postList = null;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		postList = null;
	}
	finally {
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				postList = null;
			}
		}
	}
	return postList;
}
}
