package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CheckDao;
import dao.QuestionareDao;
import model.Questionare;
import model.Result;
import model.Users;
/**
 * Servlet implementation class FaceCheckServlet
 */
@WebServlet("/FaceCheckServlet")
public class FaceCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする

		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/CAP/S_LoginServlet");
			return;
		}
//		System.out.println(session.getAttribute("user_id"));
		int user_id= (int)session.getAttribute("user_id");

		// 講師用顔文字チェックページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/facecheck.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする

		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/CAP/S_LoginServlet");
			return;
		}
//		System.out.println(session.getAttribute("user_id"));
//		int user_id= (int)session.getAttribute("user_id");

		// リクエストパラメータを取得する
		//ID以外書き込む

		request.setCharacterEncoding("UTF-8");

//		int q_id = Integer.parseInt (request.getParameter("Q_ID"));
		String q_name = request.getParameter("Q_NAME");

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
		String str = sdf.format(calendar.getTime());
		String str1 = sdf1.format(calendar.getTime());
		System.out.println(str);
		System.out.println(str1);
		Date q_date = Date.valueOf(str);
		Time q_time = Time.valueOf(str1);

		int user_id= (int)session.getAttribute("user_id");
//		int user_id = Integer.parseInt (request.getParameter("USER_ID"));

//		int user_id =1;

		// 登録処理を行う
				//すべて書き込む
				QuestionareDao bDao = new QuestionareDao();
				CheckDao cDao = new CheckDao();
				if (bDao.insert(new Questionare(0, q_name, q_date, q_time, user_id ))) {	// 登録成功
					//アンケートのIDを取ってくる
					int q_id = bDao.q_idSearch(new Questionare(0, q_name, q_date, q_time, user_id ));
					//ユーザー分の回答テーブルを作成
					ArrayList<Users> all_user_id = cDao.AllUserSelect();
					System.out.println(all_user_id);
					for(Users s_user_id : all_user_id ) {
						if(cDao.NewTableInsert(q_id, s_user_id)) {
							request.setAttribute("result",
									new Result("送信成功！", "レコードを登録しました。", "/CAP/S_MenuServlet"));
						}else {
							request.setAttribute("result",
									new Result("送信失敗！", "レコードを登録できませんでした。", "/CAP/S_MenuServlet"));
						}
					}
				}
		else {												// 登録失敗
			request.setAttribute("result",
			new Result("送信失敗！", "レコードを登録できませんでした。", "/CAP/S_MenuServlet"));
		}

		// 講師用メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/faceview.jsp");
		dispatcher.forward(request, response);
	}
}
