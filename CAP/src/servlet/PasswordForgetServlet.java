
package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SecretDao;
import model.Result;

/**
 * Servlet implementation class PasswordForgetServlet
 */
@WebServlet("/PasswordForgetServlet")
public class PasswordForgetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/CAP/S_LoginServlet");
			return;
		}
		 request.setCharacterEncoding("UTF-8");
		// パスワード忘れページににフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/passwordforget.jsp");
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
		int id = 0;	// ダミー
		String l_name = request.getParameter("L_NAME");
		String f_name = request.getParameter("F_NAME");
		String questions = request.getParameter("QUESTIONS");
		String answer = request.getParameter("ANSWER");

		System.out.println(request.getParameter("L_NAME"));
		System.out.println(request.getParameter("F_NAME"));
		System.out.println(request.getParameter("QUESTIONS"));
		System.out.println(request.getParameter("ANSWER"));

		if(l_name == "" || f_name == "" || questions == "" || answer == "") {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/CAP/jsp/passwordforget.jsp");
			dispatcher.forward(request, response);
		}

		// データの照合
		SecretDao iDao = new SecretDao();
		if (iDao.isIdOK(id, l_name, f_name, questions, answer)) {	// データと合致（isLoginOKをSecretDaoで定義）
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("id", new LoginUser(id)); //User.javaで定義

			// パスワード再設定サーブレットにリダイレクトする
			response.sendRedirect("/CAP/PasswordResetServlet");
		}
		else {									// ログイン失敗
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			request.setAttribute("result",
			new Result("ログイン失敗！", "入力に間違いがあります。", "/CAP/PasswordForgetServlet"));

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/CAP/jsp/reserve.jsp");
			dispatcher.forward(request, response);
		}
	}
}