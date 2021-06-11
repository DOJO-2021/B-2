package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class S_LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/s_login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String l_name = request.getParameter("l_name");
		String f_name = request.getParameter("f_name");
		String pw = request.getParameter("PW");

		// ログイン処理を行う
		UserDAO iDao = new UserDAO();
		if (iDao.isLoginOK(l_name,f_name,pw)) {	// ログイン成功
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("id", new LoginUser(id));

			// メニューサーブレットにリダイレクトする
			response.sendRedirect("/CAP/S_MenuServlet");
		}
		else {									// ログイン失敗
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			request.setAttribute("result",
			new Result("ログイン失敗！", "氏名またはPWに間違いがあります。", "/CAP/error.jsp"));

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
	}

	// 講師ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/t_login.jsp");
		dispatcher.forward(request, response);

		// サインインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signin.jsp");
		dispatcher.forward(request, response);

		// パスワードを忘れたらページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/passwordforget.jsp");
		dispatcher.forward(request, response);

	import React, { useRef } from "react";
	let text = "";
	 const clear = () => {
    text = "";
    // input要素のDOMオブジェクトを操作してテキストエリアをクリアする
    inputRef.current.value = "";
  };
  return (
    <>
      {input要素にrefを渡すことでDOMオブジェクトを取得する }
      <input ref={inputRef} type="text" onChange={inputValue} />
      <p>please type "ok".</p>
      <button onClick={clear}>clear</button>
      <button onClick={check}>check</button>
    </>
  );
};
*/

}