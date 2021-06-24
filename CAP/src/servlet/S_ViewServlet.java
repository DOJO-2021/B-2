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

import dao.Browsing_BDao;
import dao.Browsing_CDao;
import dao.CheckDao;
import dao.GenreDao;
import dao.PostDao;
import dao.QuestionareDao;
import model.Browsing_B;
import model.Browsing_Bs;
import model.Browsing_C;
import model.Genre;
import model.Post;
import model.Questionare;
import model.Result;

@WebServlet("/S_ViewServlet")
public class S_ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/CAP/S_LoginServlet");
			return;
		}


		//新しいアンケートがあった場合にポップを表示する
		CheckDao CTDao = new CheckDao();
		QuestionareDao QDao = new QuestionareDao();
			//ユーザーIDをセッションから持ってくる
			int user_id= (int)session.getAttribute("user_id");
			//答えていないアンケートがあるかどうかのチェック
			System.out.println(CTDao.NullQ_Check(user_id));
		if(CTDao.NullQ_Check(user_id) != 0) {
			//必要なアンケートのIDを入手する処理
			int q_id = CTDao.NullQ_Check(user_id);
			System.out.println("q_id=" + q_id);
			//必要なアンケートのデータを入手する処理
			List<Questionare> QList = QDao.NewQ_Data(q_id);
			request.setAttribute("QList", QList);
		} else {
//			System.out.println("0"+CTDao.NullQ_Check(user_id));
//			List<Questionare> QList = {};
//			System.out.println(QList.get(0));
//			request.setAttribute("QList", QList);
//			System.out.println("0001");
		}

		//投稿内容を全検索
		PostDao pDao = new PostDao();
		List<Post> PostList = pDao.postSelectAll(new Post());
		request.setAttribute("PostList", PostList);
		//ジャンル内容を全検索
		GenreDao gDao = new GenreDao();
		List<Genre> GenreList = gDao.genleSerectAll(new Genre());
		request.setAttribute("GenreList", GenreList);
		//投稿のスタンプを全検索
		Browsing_BDao sDao = new Browsing_BDao();
		List<Browsing_B> StampList = sDao.stampSelectAll(new Browsing_B());
		List<Browsing_Bs> S_CountList = sDao.CountStamp();
		request.setAttribute("StampList", StampList);
		request.setAttribute("S_CountList", S_CountList);
		//コメント内容を全検索
		Browsing_CDao bcDao = new Browsing_CDao();
		List<Browsing_C> CommentList = bcDao.commentSelectAll(new Browsing_C());
		request.setAttribute("CommentList", CommentList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/s_view.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/CAP/S_LoginServlet");
			return;
		}

		request.setCharacterEncoding("UTF-8");
		//コメント内容を保存する
		String comment = request.getParameter("comment");
		//ユーザーIDをセッションから持ってくる
		int user_id= (int)session.getAttribute("user_id");
		//コメント投稿時刻を保存する
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
		String str = sdf.format(calendar.getTime());
		String str1 = sdf1.format(calendar.getTime());
		Date date = Date.valueOf(str);
		Time time = Time.valueOf(str1);
		//ポストIDをintに変換して保存
		String id = request.getParameter("post_id");
		int Id = Integer.parseInt(id);

		//コメントをＤＢに記録する
		Browsing_CDao cDao = new Browsing_CDao();
		if (cDao.commentInsert(new Browsing_C(0,Id,comment,date,time,user_id))) {

			//投稿内容を全検索
			PostDao pDao = new PostDao();
			List<Post> PostList = pDao.postSelectAll(new Post());
			request.setAttribute("PostList", PostList);
			//ジャンル内容を全検索
			GenreDao gDao = new GenreDao();
			List<Genre> GenreList = gDao.genleSerectAll(new Genre());
			request.setAttribute("GenreList", GenreList);
			//投稿のスタンプを全検索
			//投稿のスタンプを全検索
			Browsing_BDao sDao = new Browsing_BDao();
			List<Browsing_B> StampList = sDao.stampSelectAll(new Browsing_B());
			List<Browsing_Bs> S_CountList = sDao.CountStamp();
			request.setAttribute("StampList", StampList);
			request.setAttribute("S_CountList", S_CountList);
			//コメント内容を全検索
			Browsing_CDao bcDao = new Browsing_CDao();
			List<Browsing_C> CommentList = bcDao.commentSelectAll(new Browsing_C());
			request.setAttribute("CommentList", CommentList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/s_view.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("result",
			new Result("失敗", "コメントを投稿できませんでした。", "/CAP/S_ViewServlet"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
	}
}
