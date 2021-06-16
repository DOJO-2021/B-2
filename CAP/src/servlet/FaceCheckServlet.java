package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class FaceCheckServlet
 */
@WebServlet("/FaceCheckServlet")
public class FaceCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/CAP/S_LoginServlet");
//			return;
//		}

		// 顔文字投稿ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/facepost.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/CAP/S_LoginServlet");
//			return;
//		}

		// リクエストパラメータを取得する
		//ID以外書き込む

		request.setCharacterEncoding("UTF-8");
		String check_id = request.getParameter("CHECK_ID");
		String q_id = request.getParameter("Q_ID");
		String user_id = request.getParameter("USER_ID");
		String c_comprehension_id = request.getParameter("C_COMPREHENSION_ID");
		String c_mental_id = request.getParameter("C_MENTAL_ID");
		String c_comprehension_text = request.getParameter("C_COMPREHENSION_TEXT");
		String c_mental_text = request.getParameter("C_MENTAL_TEXT");
		String c_date = request.getParameter("C_DATE");
		String c_time = request.getParameter("C_TIME");


		// 登録処理を行う
		//すべて書き込む
//		CheckDao CheckDao = new CheckDao();
//		if (CheckDao.insert(new Check1(0, q_id, user_id, c_comprehension_id, c_mental_id, c_comprehension_text, c_mental_text, c_date, c_time ))) {	// 登録成功
//			request.setAttribute("result",
//			new Result("送信成功！", "レコードを登録しました。", "/CAP/S_MenuServlet"));
//		}
//		else {												// 登録失敗
//			request.setAttribute("result",
//			new Result("送信失敗！", "レコードを登録できませんでした。", "/CAP/S_MenuServlet"));
//		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/faceview.jsp");
		dispatcher.forward(request, response);
	}
}
