package dao;
​
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
​
import model.Post;
​
public class PostDao {
​
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
​
​
​
//引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Post card) {
		Connection conn = null;
		boolean result = false;
​
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
​
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");
​
			// SQL文を準備する
			String sql = "insert into POST values (null, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
​
			// SQL文を完成させる
​
			if (card.getPost_text() != null) {
				pStmt.setString(1, card.getPost_text());
			}
			else {
				pStmt.setString(1, "null");
			}
			if (card.getGenre_id() != 0 ) {
				pStmt.setInt(2, card.getGenre_id());
			}
			else {
				pStmt.setString(2, "null");
			}
​
			if (card.getPost_date() != null) {
				pStmt.setDate(3, card.getPost_date());
			}
			else {
				pStmt.setString(3, "null");
			}
			if (card.getPost_time() != null) {
				pStmt.setTime(4, card.getPost_time());
			}
			else {
				pStmt.setString(4, "null");
			}
​
​
​
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
​
		// 結果を返す
		return result;
	}
}