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

import dao.Browsing_BDao;
import dao.Browsing_CDao;
import dao.GenreDao;
import dao.PostDao;
import model.Browsing_B;
import model.Browsing_Bs;
import model.Browsing_C;
import model.Genre;
import model.Post;
import model.Result;

/**
 * Servlet implementation class Browsing_bsServlet
 */
@WebServlet("/T_Browsing_bsServlet")
public class T_Browsing_bsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public T_Browsing_bsServlet() { super();}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/CAP/S_LoginServlet");
			return;
		}

		request.setCharacterEncoding("UTF-8");
		String Browsing_b_stamp = request.getParameter("browsing_b_stamp");
		int browsing_b_stamp = Integer.parseInt(Browsing_b_stamp);
		String Post_id = request.getParameter("post_id");
		int post_id = Integer.parseInt(Post_id);
		int user_id= (int)session.getAttribute("user_id");

		Browsing_BDao bDao = new Browsing_BDao();
		if(bDao.StampInsert(post_id, browsing_b_stamp, user_id)) {
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

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/t_view.jsp");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("result",
			new Result("失敗", "コメントを投稿できませんでした。", "/CAP/T_ViewServlet"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}

	}
}
