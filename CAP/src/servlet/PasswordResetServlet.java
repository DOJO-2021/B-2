package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BcDAO;
import model.Bc;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class PasswordResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする(セッション)
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/CAP/S_LoginServlet");
			return;
		}

		// パスワードリセット画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/CAP/jsp/passwordreset.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/CAP/S_LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_password1 = request.getParameter("USER_PASSWORD1");
		String user_password2 = request.getParameter("USER_PASSWORD2");

		// 登録処理を行う
		// user_password1とuser_password2が一致していればtrue

		BcDAO bDao = new BcDAO();
		if (bDao.insert(new Bc(user_password1))) {	// 登録成功
			request.setAttribute("result", // resultjavabeans
			new Result("登録成功！", "レコードを登録しました。", "/CAP/S_LoginServlet"));
		}
		else {												// 登録失敗
			request.setAttribute("result",
			new Result("登録失敗！", "レコードを登録できませんでした。", "/CAP/PasswordResetServlet"));
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/reserve.jsp");
		dispatcher.forward(request, response);
	}
}