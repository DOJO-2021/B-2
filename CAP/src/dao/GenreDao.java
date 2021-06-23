package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Genre;


public class GenreDao {

	public List<Genre> genleSerectAll(Genre param){
		Connection conn = null;
		List<Genre> genreList = new ArrayList<Genre>();

	try {
		Class.forName("org.h2.Driver");
		conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");

		String sql = "select genre_id, genre_name from genre ORDER BY genre_id";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		ResultSet rs = pStmt.executeQuery();
		while (rs.next()) {
			Genre card = new Genre(
			rs.getInt("genre_id"),
			rs.getString("genre_name")
			);
			genreList.add(card);
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
		genreList = null;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		genreList = null;
	}
	finally {
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				genreList = null;
			}
		}
	}
	return genreList;
}

	public boolean insertGenre(String genre_name) {
		Connection conn = null;
		boolean result = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");

			// SQL文を準備する
			String sql = "insert into genre values (null,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, genre_name);

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
