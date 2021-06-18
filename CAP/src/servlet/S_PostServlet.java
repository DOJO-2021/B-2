package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GenreDao;
import dao.PostDao;
import model.Genre;
import model.Post;
import model.Result;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/S_PostServlet")
public class S_PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("user_id") == null) {
					response.sendRedirect("/CAP/S_LoginServlet");
					return;
				}
		//ジャンル内容を全検索
		GenreDao gDao = new GenreDao();
		List<Genre> GenreList = gDao.genleSerectAll(new Genre());
		request.setAttribute("GenreList", GenreList);

		// 投稿ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/s_post.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("user_id") == null) {
					response.sendRedirect("/CAP/S_LoginServlet");
					return;
				}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

		//投稿内容の取得
		String post_text = request.getParameter("post_text");
		//ジャンルIDの取得
		int genre_id =Integer.parseInt (request.getParameter("genre"));
		//ユーザーIDの取得
		int user_id= (int)session.getAttribute("user_id");
		//日時の取得
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
		String str = sdf.format(calendar.getTime());
		String str1 = sdf1.format(calendar.getTime());
		Date post_date = Date.valueOf(str);
		Time post_time = Time.valueOf(str1);


		// 投稿の登録処理を行う
		PostDao bDao = new PostDao();
		if (bDao.insert(new Post(0, user_id, post_text, genre_id, post_date, post_time))) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/s_menu.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("result",
			new Result("登録失敗！", "レコードを登録できませんでした。", "/CAP/S_MenuServlet"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
	}
}
