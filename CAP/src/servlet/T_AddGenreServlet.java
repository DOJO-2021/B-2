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

/**
 * Servlet implementation class T_AddGenreServlet
 */
@WebServlet("/T_AddGenreServlet")
public class T_AddGenreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public T_AddGenreServlet() {super();}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/CAP/S_LoginServlet");
			return;
		}

	         	request.setCharacterEncoding("UTF-8");
				String genre_name =  request.getParameter("GenreName");

				GenreDao gaDao = new GenreDao();
				if (gaDao.insertGenre(genre_name)) {

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
					request.setAttribute("StampList", StampList);
					//コメント内容を全検索
					Browsing_CDao bcDao = new Browsing_CDao();
					List<Browsing_C> CommentList = bcDao.commentSelectAll(new Browsing_C());
					request.setAttribute("CommentList", CommentList);


					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/t_view.jsp");
					dispatcher.forward(request, response);
				}
				else {
					request.setAttribute("result",
					new Result("失敗", "ジャンルを追加できませんでした。", "/CAP/S_ViewServlet"));
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
					dispatcher.forward(request, response);
				}

	}

}
