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

import dao.UserDao;
import model.Result;
import model.User;

/**
 * Servlet implementation class PasswordResetServlet
 */
@WebServlet("/PasswordResetServlet")
public class PasswordResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもpasswordforget.jspで入力がなければPasswordForgetサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_secret") == null) {
			response.sendRedirect("/CAP/PasswordForgetServlet");
			return;
		}

		// パスワードリセット画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/passwordreset.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもpasswordforget.jspで入力がなければPasswordForgetサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_secret") == null) {
			response.sendRedirect("/CAP/PasswordForgetServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_password1 = request.getParameter("USER_PASSWORD1");
		String user_password2 = request.getParameter("USER_PASSWORD2");

		List<User> user_secret = (List<User>) session.getAttribute("user_secret");
		int user_id = user_secret.get(0).getUser_id();
		String user_l_name = user_secret.get(0).getUser_l_name();
		String user_f_name = user_secret.get(0).getUser_f_name();
		String secret_id = user_secret.get(0).getSecret_id();
		String user_answer = user_secret.get(0).getUser_answer();
		int user_type = user_secret.get(0).getUser_type();

		System.out.println(user_password1);
		System.out.println(user_password2);


		// パスワード更新処理を行う
		// user_password1とuser_password2が一致していればtrue
		if(user_password1.equals(user_password2)) {
			UserDao bDao = new UserDao();
			if (bDao.update(new User(user_id, user_l_name, user_f_name, user_password1, secret_id,user_answer,user_type))) {	// 更新成功
				request.setAttribute("result", // resultjavabeans
				new Result("更新成功！", "パスワードを登録しました。", "/CAP/S_LoginServlet"));
			} else {												// 更新失敗
				request.setAttribute("result",
				new Result("更新失敗！", "パスワードを登録できませんでした。", "/CAP/PasswordResetServlet"));
			}
		} else {												// 更新失敗
			request.setAttribute("result",
			new Result("更新失敗！", "パスワードが間違っています。", "/CAP/PasswordResetServlet"));
		}

		// セッションスコープを破棄する
		HttpSession session2 = request.getSession();
		session2.invalidate();

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
		dispatcher.forward(request, response);

	}

}
