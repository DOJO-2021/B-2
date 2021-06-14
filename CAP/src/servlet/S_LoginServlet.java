package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/S_LoginServlet")
public class S_LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/s_login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_l_name = request.getParameter("user_l_name");
		String user_f_name = request.getParameter("user_f_name");
		String pw = request.getParameter("user_password");

		// ログイン処理を行う
		UserDAO iDao = new UserDAO();
		if (iDao.isLoginOK(user_l_name,user_f_name,user_pw)) {	// ログイン成功
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("user_id", new LoginUser(user_id));

			// メニューサーブレットにリダイレクトする
			response.sendRedirect("/CAP/S_MenuServlet");
		}
		else {									// ログイン失敗
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			request.setAttribute("result",
			new Result("ログイン失敗！", "氏名またはPWに間違いがあります。", "/CAP/error.jsp"));

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
	}

	// 講師ログインページにリダイレクトする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/CAP/T_LoginServlet");
		dispatcher.forward(request, response);

		// サインインページにリダイレクトする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/CAP/SigninServlet");
		dispatcher.forward(request, response);

		// パスワードを忘れたらページにリダイレクトする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/CAP/PasswordForgetServlet");
		dispatcher.forward(request, response);
}