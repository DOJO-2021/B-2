package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.Result;
import model.User;


/**
 * Servlet implementation class SigninServlet
 */
@WebServlet("/SigninServlet")
public class SigninServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// サインインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signin.jsp");
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
			String user_password = request.getParameter("user_password");
			String user_questions = request.getParameter("user_questions");
			String user_answer = request.getParameter("user_answer");
			String user_word_s = request.getParameter("user_word_s");
			String user_word_t = request.getParameter("user_word_t");

			// 登録処理を行う
			UserDao bDao = new UserDao();
//			User test_user = new User(0,user_l_name, user_f_name, user_password, user_questions, user_answer, user_word_s, user_word_t, 0();
			if (bDao.insert(new User(0,user_l_name, user_f_name, user_password, user_questions, user_answer, user_word_s, user_word_t, 0))) {	// 登録成功
				request.setAttribute("result",
				new Result("登録完了","アカウントを登録しました。ログインページからログインしてください。", "/CAP/S_LoginServlet"));
			}
			else {												// 登録失敗
				request.setAttribute("result",
				new Result("登録失敗", "アカウントをを登録できませんでした。もう一度やり直してください。", "/CAP/SigninServlet"));
			}

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);


		}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	}
