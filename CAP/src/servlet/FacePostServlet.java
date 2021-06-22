package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import dao.QuestionareDao;
import dao.CheckDao;
import model.Result;


@WebServlet("/FacePostServlet")
public class FacePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/CAP/S_LoginServlet");
			return;
		}

		// 受講生顔文字投稿にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/facepost.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/CAP/S_LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		//ユーザーIDを取ってくる
		int user_id= (int)session.getAttribute("user_id");
		//アンケートIDを取ってくる
		int q_id = Integer.parseInt (request.getParameter("q_id"));
		//アンケートデータを取ってくる
		int c_comprehension_id = Integer.parseInt (request.getParameter("C_COMPREHENSION_ID"));
		int c_mental_id = Integer.parseInt (request.getParameter("C_MENTAL_ID"));
		String c_comprehension_text = request.getParameter("C_COMPREHENSION_TEXT");
		String c_mental_text = request.getParameter("C_MENTAL_TEXT");
		//日時データを作成する
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
		String str = sdf.format(calendar.getTime());
		String str1 = sdf1.format(calendar.getTime());
		Date c_date = Date.valueOf(str);
		Time c_time = Time.valueOf(str1);

		// 登録処理を行う
		//すべて書き込む
		CheckDao bDao = new CheckDao();
		if (bDao.A_update(q_id, user_id, c_comprehension_id, c_mental_id, c_comprehension_text, c_mental_text, c_date, c_time)) {	// 登録成功
			request.setAttribute("result",
			new Result("送信成功！", "レコードを登録しました。", "/CAP/S_MenuServlet"));
		}
		else {												// 登録失敗
			request.setAttribute("result",
			new Result("送信失敗！", "レコードを登録できませんでした。", "/CAP/S_MenuServlet"));
		}

		// 受講生用メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
		dispatcher.forward(request, response);
	}
}
