package servlet;

import java.io.IOException;

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
		// もしもログインしていなかったらログインサーブレットにリダイレクトする(セッション)
		HttpSession session = request.getSession();
		if (session.getAttribute("user_type_id") == null) {
			response.sendRedirect("/CAP/S_LoginServlet");
			return;
		}

		// パスワードリセット画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/passwordreset.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_type_id") == null) {
			response.sendRedirect("/CAP/S_LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_password1 = request.getParameter("USER_PASSWORD1");
		String user_password2 = request.getParameter("USER_PASSWORD2");
		int user_type_id = Integer.parseInt((String)session.getAttribute("user_type_id"));

		System.out.println(user_password1);
		System.out.println(user_password2);

		// パスワード更新処理を行う
		// user_password1とuser_password2が一致していればtrue
		if(user_password1.equals(user_password2)) {
			UserDao bDao = new UserDao();
			if (bDao.update(new User(user_type_id, "", "", user_password1, "", "", 0))) {	// 更新成功
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

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
		dispatcher.forward(request, response);

	}

}
