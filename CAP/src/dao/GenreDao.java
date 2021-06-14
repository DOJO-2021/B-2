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


}
