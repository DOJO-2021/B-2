package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PostDao;
import model.Post;

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


		String post_text = request.getParameter("post_text");
		int genre_id =Integer.parseInt (request.getParameter("genre"));
		//String user_id = request.getParameter("user_id");
		System.out.println(session.getAttribute("user_id"));
		int user_id= (int)session.getAttribute("user_id");
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
		String str = sdf.format(calendar.getTime());
		String str1 = sdf1.format(calendar.getTime());
		System.out.println(str);
		System.out.println(str1);
		Date post_date = Date.valueOf(str);
		Time post_time = Time.valueOf(str1);

//

//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(date);
//
//		calendar.getTime();
//		long time = date.getTime();
		//Time time = new Time();



		//int型に変更

//		System.out.println(post_text);
//		System.out.println(genre_id);
//		System.out.println(date);
//		System.out.println(user_id);
////		System.out.println(calendar.getTime());
//		System.out.println(calendar);


//		long min = 1000 * 60;
//		long hour = min * 60;
//		long day = hour * 24;
//		long month = day * 31;
//		long year = day * 365;
//		System.out.println(min);



		// 投稿の登録処理を行う
		PostDao bDao = new PostDao();
		if (bDao.insert(new Post(0, user_id, post_text, genre_id, post_date, post_time))) {	// 登録成功
			//request.setAttribute("result",
			//new Result("登録が完了しました！", "検索ページから確認ができます。", "/CAP/S_MenuServlet"));
		}
//		else {												// 登録失敗
//			request.setAttribute("result",
//			new Result("登録失敗！", "レコードを登録できませんでした。", "/CAP/S_MenuServlet"));
//		}
////
 //結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/s_menu.jsp");
		dispatcher.forward(request, response);
	}
}
