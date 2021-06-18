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
import model.Browsing_C;
import model.Genre;
import model.Post;
import model.Result;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/CAP/S_LoginServlet");
			return;
		}

		request.setCharacterEncoding("UTF-8");


		int user_id= (int)session.getAttribute("user_id");
		String Post_id = request.getParameter("post_id");
		int post_id = Integer.parseInt(Post_id);

		PostDao cDao = new PostDao();
		if (cDao.PostUser_id(post_id) == user_id) {
			if(cDao.commentDelete(post_id)) {

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
				new Result("失敗", "投稿を削除できませんでした。", "/CAP/S_ViewServlet"));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				dispatcher.forward(request, response);
			}
		} else {
				//System.out.println(cDao.PostUser_id(post_id));
				request.setAttribute("result",
				new Result("失敗", "投稿を削除する権限がありません", "/CAP/S_ViewServlet"));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				dispatcher.forward(request, response);
		}
	}
}
