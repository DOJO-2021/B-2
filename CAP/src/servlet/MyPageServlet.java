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
import model.User;


/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/MyPageServlet")
public class MyPageServlet extends HttpServlet {
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

		// 検索処理を行う
		UserDao uDao = new UserDao();
		List<User> cardList = uDao.select(new User());


		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList); // リクエストにcardListの情報が入っている


		// マイページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
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


		//リクエストパラメータの取得
		String password = request.getParameter("PASSWORD");
		String questions = request.getParameter("QUESTIONS");
		String answer = request.getParameter("ANSWER");

		// 更新または削除を行う
//		UserDao uDao = new UserDao();
//		if (request.getParameter("OK").equals("OK")) {
//			if (uDao.update(new User(0, "", "", password, questions, answer, "", "", 0))) {	// 更新成功　updateはtrueかfalseを返しているメソッド\
//				request.setAttribute("result",														// result...領域,何もない下駄箱（名前がついている）みたいな感じ
//				new Result("更新成功！", "レコードを更新しました。", "/CAP/MyPageServlet")); 	// Result 箱(タンスみたいなもの)
//
//			}
//			else {												// 更新失敗
//				request.setAttribute("result",
//				new Result("更新失敗！", "レコードを更新できませんでした。", "/CAP/MyPageServlet"));
//			}
//		}
//
//		// 更新/削除された後のデータを持ってくる
//		List<User> cardList = uDao.select(new User(0, "", "", "", "", "", "", "", 0));

		// 検索結果をリクエストスコープに格納する
//		request.setAttribute("cardList", cardList);


		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		dispatcher.forward(request, response);
	}
}