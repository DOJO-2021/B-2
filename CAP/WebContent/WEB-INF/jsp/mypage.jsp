<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>みんなの気持ち教えてくだサイト</title>
</head>
<body>
	<header>
		<h1>みんなの気持ち教えてくだサイト</h1>
	</header>
	<main>
		<p>アカウント</p>
		<p>こんにちは、
		<c:out value="${cardList.get(0).user_l_name}" />
		<c:out value="${cardList.get(0).user_f_name}" />さん</p>

	 				  <form method="POST" action="/CAP/MyPageServlet">
						<table>
							<tr>
								<th>秘密の質問</th>
								<td><select name="QUESTIONS">
									<option value="1">出身地は？</option>
									<option value="2">親の旧姓は？</option>
									<option value="3">ペットの名前は？</option>
									<option value="4">母校（小学校）の名称は？</option>
									<option value="5">初めての海外旅行先は？</option></select></td>
							</tr>
							<tr>
								<th>答え<th><td><input type="text" name="ANSWER" value="${cardList[0].user_answer}"></td>
							</tr>
						</table>
			<input type="submit" name="OK" value="OK">
			</form>
			<input type="reset" value="リセット">
			<a href="/CAP/S_MenuServlet.java">ホームに戻る</a>
	</main>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="/CAP/js/mypage.js"></script>
</body>
</html>