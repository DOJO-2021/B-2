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
 * Servlet implementation class RegistServlet
 */
@WebServlet("/FaceCheckServlet")
public class FaceCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/CAP/S_LoginServlet");
//			return;
//		}
//
//		// 登録ページにフォワードする
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signin.jsp");
//		dispatcher.forward(request, response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
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
		String c_comprehension_text = request.getParameter("POSITION");
		String address = request.getParameter("ADDRESS");
		String phone = request.getParameter("PHONE");
		String mail = request.getParameter("MAIL");
		String remarks = request.getParameter("REMARKS");

		// 登録処理を行う
		//すべて書き込む
		BcDAO bDao = new BcDAO();
		if (bDao.insert(new Bc(0, company, company_hurigana, name, name_hurigana, department, position, address, phone , mail, remarks))) {	// 登録成功
			request.setAttribute("result",
			new Result("登録成功！", "レコードを登録しました。", "/simpleBC/MenuServlet"));
		}
		else {												// 登録失敗
			request.setAttribute("result",
			new Result("登録失敗！", "レコードを登録できませんでした。", "/simpleBC/MenuServlet"));
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
	}
}
