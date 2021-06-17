package servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.Result;
import model.User;
/**
 * Servlet implementation class SigninServlet
 */
@WebServlet("/SigninServlet")
public class SigninServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      HttpSession session = request.getSession();
//      if (session.getAttribute("user_id") == null) {
//          response.sendRedirect("/CAP/S_LoginServlet");
//          return;
//      }
	// サインインページにフォワードする
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signin.jsp");
        dispatcher.forward(request, response);

    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // リクエストパラメータを取得する
            request.setCharacterEncoding("UTF-8");
            String user_l_name = request.getParameter("user_l_name");
            String user_f_name = request.getParameter("user_f_name");
            String user_password = request.getParameter("user_password");
            String secret_id = request.getParameter("secret_id");
            String user_answer = request.getParameter("user_answer");
            int user_type = Integer.parseInt(request.getParameter("user_type"));

            //合言葉の判断をする
            String user_word = request.getParameter("user_word");
            if((user_word.equals( "j001") && user_type == 1) || (user_word.equals("k009") && user_type == 2)) {

            	 // 登録処理を行う
                 UserDao bDao = new UserDao();
                 if (bDao.insert(new User(0,user_l_name, user_f_name, user_password, secret_id, user_answer,user_type ))) {   // 登録成功
                     request.setAttribute("result",
                     new Result("登録完了","アカウントを登録しました。ログインページからログインしてください。", "/CAP/S_LoginServlet"));
                 }
                 else {                                              // 登録失敗
                     request.setAttribute("result",
                     new Result("登録失敗", "アカウントをを登録できませんでした。もう一度やり直してください。", "/CAP/SigninServlet"));
                 }
            }else{
            	request.setAttribute("result",
                        new Result("登録失敗", "合言葉が間違っています。もう一度やり直してください。", "/CAP/SigninServlet"));
            }
            // 結果ページにフォワードする
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
            dispatcher.forward(request, response);
    }
}
