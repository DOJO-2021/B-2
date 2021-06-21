
package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SecretDao;
import model.Result;
import model.User;

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
//	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String l_name = request.getParameter("L_NAME");
		String f_name = request.getParameter("F_NAME");
		String secret_id = request.getParameter("QUESTIONS");
		String user_answer = request.getParameter("ANSWER");

		System.out.println(l_name);
		System.out.println(f_name);
		System.out.println(secret_id);
		System.out.println(user_answer);

		if(l_name == "" || f_name == "" || user_answer == "") {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/passwordforget.jsp");
			dispatcher.forward(request, response);
		}

		// データの照合
		SecretDao iDao = new SecretDao();

		if (iDao.isIdOK(l_name, f_name, secret_id, user_answer)) {	// データと合致（isIdOKをSecretDaoで定義）

			// 検索処理を行う
			SecretDao bDao = new SecretDao();
			List<User> cardList = bDao.selectSecret(new User(0,l_name, f_name, "",secret_id,user_answer, 0));

			// セッションスコープにID,user_typeを格納する
			HttpSession session = request.getSession();
			session.setAttribute("user_secret", cardList);
//			List<User> user_secret = (List<User>) session.getAttribute("user_secret");

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