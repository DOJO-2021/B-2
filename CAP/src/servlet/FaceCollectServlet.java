package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/CAP/T_LoginServlet.java");
			return;
		}

		// 検索ページにフォワードする
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
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/CAP/T_LoginServlet.java");
			return;
		}

		// リクエストパラメータを取得する
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


		// 検索処理を行う
//	    CheckDao CheckDao = new CheckDao();
//		List<FaceCheck> FaceCheckList = .select(new Bc(0, q_id, user_id, c_comprehension_id, c_mental_id, c_comprehension_text,c_mental_text,c_date,c_time));
//
//		// 検索結果をリクエストスコープに格納する
//		request.setAttribute("cardList", cardList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search_result.jsp");
		dispatcher.forward(request, response);
	}
}
