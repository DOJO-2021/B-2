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
	//蠑墓焚card縺ｧ謖・ｮ壹＆繧後◆繝ｬ繧ｳ繝ｼ繝峨ｒ逋ｻ骭ｲ縺励∵・蜉溘＠縺溘ｉtrue繧定ｿ斐☆
		public boolean insert(Post card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBC繝峨Λ繧､繝舌ｒ隱ｭ縺ｿ霎ｼ繧
				Class.forName("org.h2.Driver");

				// 繝・・繧ｿ繝吶・繧ｹ縺ｫ謗･邯壹☆繧・
				conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");

				// SQL譁・ｒ貅門ｙ縺吶ｋ
				String sql = "insert into POST(post_id, user_id, post_text, genre_id, post_date, post_time) values (null, ?, ?, ?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL譁・ｒ螳梧・縺輔○繧・
				if (card.getUser_id() != 0) {
					pStmt.setInt(1, card.getUser_id());
				}
				else {
					pStmt.setString(1, "null");
				}
				if (card.getPost_text() != null) {
					pStmt.setString(2, card.getPost_text());
				}
				else {
					pStmt.setString(2, "null");
				}
				if (card.getGenre_id() != 0 ) {
					pStmt.setInt(3, card.getGenre_id());
				}
				else {
					pStmt.setString(3, "null");
				}
				if (card.getPost_date() != null) {
					pStmt.setDate(4, card.getPost_date());
				}
				else {
					pStmt.setString(4, "null");
				}

				if (card.getPost_time() != null) {
					pStmt.setTime(5, card.getPost_time());
				}
				else {
					pStmt.setString(5, "null");
				}



				// SQL譁・ｒ螳溯｡後☆繧・
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
				// 繝・・繧ｿ繝吶・繧ｹ繧貞・譁ｭ
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 邨先棡繧定ｿ斐☆
			return result;
		}

		public int PostUser_id(int post_id) {
			Connection conn = null;
			int card = 0;

			try {
				Class.forName("org.h2.Driver");
				conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");
				String sql1 = "select user_id from post where post_id = 1";
				PreparedStatement pStmt = conn.prepareStatement(sql1);
				System.out.println("post_id:"+post_id);
//				pStmt.setInt(1, post_id);
				System.out.println("pStmt:"+pStmt);
				ResultSet rs1 = pStmt.executeQuery();
				System.out.println("select rows:"+rs1.getRow());	//行数
				card = rs1.getInt("user_id");

				System.out.println(card);

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

		public boolean commentDelete(int post_id) {
			Connection conn = null;
			boolean result = false;

			try {
				Class.forName("org.h2.Driver");
				conn = DriverManager.getConnection("jdbc:h2:file:C:\\pleiades\\workspace\\B-2\\CAP\\capdb", "sa", "sa");
				String sql = "delete from post where post_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setInt(1, post_id);

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
