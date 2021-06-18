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

import dao.CheckDao;
import model.Check;
import model.Result;
/**
 * Servlet implementation class FaceCheckServlet
 */
@WebServlet("/FacePostServlet")
public class FacePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする

		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/CAP/S_LoginServlet");
			return;
		}
//	System.out.println(session.getAttribute("user_id"));
//		Object obj = session.getAttribute("user_id");
//		String user = obj.toString();
//		int user_id = Integer.parseInt(user);

		// 受講生顔文字投稿にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/facepost.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/CAP/S_LoginServlet");
			return;
		}
//		System.out.println(session.getAttribute("user_id"));
		Object obj = session.getAttribute("user_id");
		String user = obj.toString();
		int user_id = Integer.parseInt(user);

		// リクエストパラメータを取得する
		//ID以外書き込む

		request.setCharacterEncoding("UTF-8");

		int q_id = Integer.parseInt (request.getParameter("Q_ID"));

		int c_comprehension_id = Integer.parseInt (request.getParameter("C_COMPREHENSION_ID"));
		int c_mental_id = Integer.parseInt (request.getParameter("C_MENTAL_ID"));
		String c_comprehension_text = request.getParameter("C_COMPREHENSION_TEXT");
		String c_mental_text = request.getParameter("C_MENTAL_TEXT");

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
		String str = sdf.format(calendar.getTime());
		String str1 = sdf1.format(calendar.getTime());
		System.out.println(str);
		System.out.println(str1);
		Date c_date = Date.valueOf(str);
		Time c_time = Time.valueOf(str1);





		// 登録処理を行う
		//すべて書き込む
		CheckDao bDao = new CheckDao();
		if (bDao.insert(new Check(0, q_id, user_id, c_comprehension_id, c_mental_id, c_comprehension_text, c_mental_text, c_date, c_time ))) {	// 登録成功
			request.setAttribute("result",
			new Result("送信成功！", "レコードを登録しました。", "/CAP/S_MenuServlet"));
		}
		else {												// 登録失敗
			request.setAttribute("result",
			new Result("送信失敗！", "レコードを登録できませんでした。", "/CAP/S_MenuServlet"));
		}

		// 講師用メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/faceview.jsp");
		dispatcher.forward(request, response);
	}
}
