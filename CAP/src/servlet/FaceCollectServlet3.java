package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CheckDao;
import dao.FaceCalculateDao;
import dao.QuestionNameDao;
import model.AllData;
import model.Check;
import model.FaceMarks;
import model.Questionare;
/**
 * Servlet implementation class FaceCollectServlet3
 */
@WebServlet("/FaceCollectServlet3")
public class FaceCollectServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
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
//		int user_id= (int)session.getAttribute("user_id");


		//受講生からのアンケート回答内容を全検索
		CheckDao cDao = new CheckDao();
		List<AllData> alldataList = cDao.AllData();
		request.setAttribute("alldataList", alldataList);

		//アンケート名を取得
		QuestionNameDao question_name = new QuestionNameDao();
		List<Questionare> q_nameList = question_name.NewQ_Data();
		request.setAttribute("q_nameList", q_nameList);

////ユーザーデータを取得
//		UserDao uDao = new UserDao();
//		List<User> userList = uDao.select(new User());
//		request.setAttribute("userList", userList);


//AllDataデータを取得
//		AllDataDao aDao = new AllDateDao();
//		List<AllData> alldataList = aDao.select(new AllData());
//		request.setAttribute("alldataList", alldataList);


		// 理解度の集計結果
		FaceCalculateDao fcDao = new FaceCalculateDao();
				List<FaceMarks> FCList = fcDao.faceComprehension();

				for(FaceMarks FC:FCList) {
					System.out.println("理解度"+FC);

				}
//
//				// メンタルの集計結果
				FaceCalculateDao fmDao = new FaceCalculateDao();
						List<FaceMarks> FMList = fmDao.faceMental();

						for(FaceMarks FM:FMList) {
							System.out.println("メンタル"+FM);
						}

						request.setAttribute("FMList", FMList);


//
//
		request.setAttribute("FCList", FCList);

		// 講師用顔文字閲覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/faceview3.jsp");
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
		int q_id = Integer.parseInt (request.getParameter("Q_ID"));
		int user_id= (int)session.getAttribute("user_id");

		int c_comprehension_id = Integer.parseInt (request.getParameter("C_COMPREHENSION_ID"));
		int c_mental_id = Integer.parseInt (request.getParameter("C_MENTAL_ID"));
		String c_comprehension_text = request.getParameter("C_COMPREHENSION_TEXT");
		String c_mental_text = request.getParameter("C_MENTAL_TEXT");

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
		String str = sdf.format(calendar.getTime());
		String str1 = sdf1.format(calendar.getTime());
		System.out.println(str);
		System.out.println(str1);
		Date c_date = Date.valueOf(str);
		Time c_time = Time.valueOf(str1);


		// 検索処理を行う
	    CheckDao cDao = new CheckDao();
		List<Check> checkList = cDao.checkSelectAll(new Check(0, q_id, user_id, c_comprehension_id, c_mental_id, c_comprehension_text,c_mental_text,c_date,c_time));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("checkList", checkList);

		// 結果ページにフォワードする



		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/faceview3.jsp");
		dispatcher.forward(request, response);

//
	}
}
