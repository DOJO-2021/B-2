package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/S_ViewServlet")
public class S_ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user-id") == null) {
			response.sendRedirect("/CAP/LoginServlet");
			return;
		}

		//ページに飛ばす前に全投稿のデータを収集しておく　OR　ページ遷移によって表示内容変更


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/s_view.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user-id") == null) {
			response.sendRedirect("/CAP/LoginServlet");
			return;
		}

		//コメントを登録する

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/s_view.jsp");
		dispatcher.forward(request, response);
	}
}
