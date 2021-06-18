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

import dao.Browsing_BDao;
import dao.Browsing_CDao;
import dao.GenreDao;
import dao.PostDao;
import model.Browsing_B;
import model.Browsing_C;
import model.Genre;
import model.Post;
import model.Result;

@WebServlet("/S_ViewServlet")
public class S_ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	HttpSession session = request.getSession();
	//	if (session.getAttribute("user-id") == null) {
	//		response.sendRedirect("/CAP/S_LoginServlet");
	//		return;
	//	}


		PostDao pDao = new PostDao();
		List<Post> PostList = pDao.postSelectAll(new Post());
		request.setAttribute("PostList", PostList);

		GenreDao gDao = new GenreDao();
		List<Genre> GenreList = gDao.genleSerectAll(new Genre());
		request.setAttribute("GenreList", GenreList);

		Browsing_BDao sDao = new Browsing_BDao();
		List<Browsing_B> StampList = sDao.stampSelectAll(new Browsing_B());
		request.setAttribute("StampList", StampList);

		Browsing_CDao cDao = new Browsing_CDao();
		List<Browsing_C> CommentList = cDao.commentSelectAll(new Browsing_C());
		request.setAttribute("CommentList", CommentList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/s_view.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		if (session.getAttribute("user-id") == null) {
//			response.sendRedirect("/CAP/LoginServlet");
//			return;
//		}

		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("post_id");
		String comment = request.getParameter("comment");
//		Strinig user_id = session.getAttribute("user-id");

		int user_id = 1;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
		String str = sdf.format(calendar.getTime());
		String str1 = sdf1.format(calendar.getTime());
		System.out.println(str);
		System.out.println(str1);
		Date date = Date.valueOf(str);
		Time time = Time.valueOf(str1);

		int Id = Integer.parseInt(id);
//		Date Date = Date.valueOf(date);
//		Time Time = Time.valueOf(time);
//		int User_id = Integer.parseInt(user_id);

		Browsing_CDao cDao = new Browsing_CDao();
		if (cDao.commentInsert(new Browsing_C(0,Id,comment,date,time,user_id))) {

			PostDao pDao = new PostDao();
			List<Post> PostList = pDao.postSelectAll(new Post());
			request.setAttribute("PostList", PostList);

			GenreDao gDao = new GenreDao();
			List<Genre> GenreList = gDao.genleSerectAll(new Genre());
			request.setAttribute("GenreList", GenreList);

			Browsing_BDao sDao = new Browsing_BDao();
			List<Browsing_B> StampList = sDao.stampSelectAll(new Browsing_B());
			request.setAttribute("StampList", StampList);

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
