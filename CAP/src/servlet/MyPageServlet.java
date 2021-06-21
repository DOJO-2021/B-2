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
import dao.UserDao;
import model.Result;
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
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/CAP/S_LoginServlet");
			return;
		}
//		System.out.println(session.getAttribute("user_id"));

		Object obj = session.getAttribute("user_id");
		String user = obj.toString();
		int user_id = Integer.parseInt(user);
//		int user_id= (int)session.getAttribute("user_id");

		System.out.println(user_id);

		// 検索処理を行う
		SecretDao uDao = new SecretDao();
		List<User> cardList = uDao.selectById(new User(user_id,"","","","","",0));

//		System.out.println(cardList.get(0).getUser_f_name());

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
		if (session.getAttribute("user_id_type") == null) {
			response.sendRedirect("/CAP/S_LoginServlet");
			return;
		}

		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String user_l_name = request.getParameter("user_l_name");
		String user_f_name = request.getParameter("user_f_name");
		String user_password = request.getParameter("user_password");
		String questions = request.getParameter("QUESTIONS");
		String answer = request.getParameter("ANSWER");
		int user_type = Integer.parseInt(request.getParameter("user_type"));
		int user_id= (int)session.getAttribute("user_id");


		System.out.println(questions);
		System.out.println(answer);

		// 更新または削除を行う
		UserDao uDao = new UserDao();
		if (request.getParameter("OK").equals("OK")) {
			if (uDao.update(new User(user_id, user_l_name, user_f_name, user_password, questions, answer,user_type))) {	// 更新成功　updateはtrueかfalseを返しているメソッド\
				request.setAttribute("result",														// result...領域,何もない下駄箱（名前がついている）みたいな感じ
				new Result("更新成功！", "レコードを更新しました。", "/CAP/MyPageServlet")); 	// Result 箱(タンスみたいなもの)

			}
			else {												// 更新失敗
				request.setAttribute("result",
				new Result("更新失敗！", "レコードを更新できませんでした。", "/CAP/MyPageServlet"));
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
		dispatcher.forward(request, response);

		// 更新/削除された後のデータを持ってくる
		List<User> cardList = uDao.select(new User(0, "", "", "", "", "", 0));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		dispatcher2.forward(request, response);
	}
}