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

import dao.CheckDao;
import model.Check;
/**
 * Servlet implementation class FaceCollectServlet
 */
@WebServlet("/FaceCollectServlet")
public class FaceCollectServlet extends HttpServlet {
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
//		System.out.println(session.getAttribute("user_id"));
		int user_id= (int)session.getAttribute("user_id");

		// 講師用顔文字閲覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/faceview.jsp");
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
//		int user_id= (int)session.getAttribute("user_id");

		// リクエストパラメータを取得する
		int q_id = Integer.parseInt (request.getParameter("Q_ID"));
		int user_id= (int)session.getAttribute("user_id");

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


		// 検索処理を行う
	    CheckDao cDao = new CheckDao();
		List<Check> FaceCheckList = cDao.select(new Check(0, q_id, user_id, c_comprehension_id, c_mental_id, c_comprehension_text,c_mental_text,c_date,c_time));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("FaceCheckList", FaceCheckList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/faceview.jsp");
		dispatcher.forward(request, response);
	}
}
