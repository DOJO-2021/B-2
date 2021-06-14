package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class S_MenuServlet
*/

@WebServlet("/S_MenuServlet")
  public class S_MenuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //もしもログインしていなかったらログインサーブレットにリダイレクトする
  /*  HttpSession session = request.getSession();
    if (session.getAttribute("l_name") == null) {
        response.sendRedirect("/CAP/S_LoginServlet");
        return;
    }*/

    // メニューページにフォワードする
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/s_menu.jsp");
    dispatcher.forward(request,response);
    }
}