
package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// パスワード忘れページににフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/passwordforget.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String l_name = request.getParameter("L_NAME");
		String f_name = request.getParameter("F_NAME");
		String questions = request.getParameter("QUESTIONS");
		String answer = request.getParameter("ANSWER");

		System.out.println(l_name);
		System.out.println(f_name);
		System.out.println(questions);
		System.out.println(answer);

		if(l_name == "" || f_name == "" || answer == "") {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/passwordforget.jsp");
			dispatcher.forward(request, response);
		}

		// データの照合
		SecretDao iDao = new SecretDao();

		if (iDao.isIdOK(l_name, f_name, questions, answer)) {	// データと合致（isIdOKをSecretDaoで定義）

			// パスワード再設定サーブレットにリダイレクトする
			response.sendRedirect("/CAP/PasswordResetServlet");
		}
		else {									// ログイン失敗
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			request.setAttribute("result",
			new Result("ログイン失敗！", "入力に間違いがあります。", "/CAP/PasswordForgetServlet"));

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}



	}
}