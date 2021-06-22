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
	 				  <input type="hidden" name="user_l_name" id="result" value="${cardList.get(0).user_l_name}">
	 				  <input type="hidden" name="user_f_name" id="result" value="${cardList.get(0).user_f_name}">
	 				  <input type="hidden" name="user_password" id="result" value="${cardList.get(0).user_password}">
	 				  <input type="hidden" name="user_type" id="result" value="${cardList.get(0).user_type}">
						<table>
							<tr>
								<th>秘密の質問</th>
								<td><select name="QUESTIONS" id="${cardList.get(0).secret_id}">
									<option value="1">出身地は？</option>
									<option value="2">親の旧姓は？</option>
									<option value="3">ペットの名前は？</option>
									<option value="4">母校（小学校）の名称は？</option>
									<option value="5">初めての海外旅行先は？</option>
									</select></td>
							</tr>
							<tr>
								<th>答え<th><td><input type="text" name="ANSWER" value="${cardList[0].user_answer}"></td>
							</tr>
						</table>
			<input type="submit" name="OK" value="OK">
			<input type="reset" value="リセット">
			</form>

			<a href="/CAP/S_MenuServlet">ホームに戻る</a>
	</main>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="/CAP/js/mypage.js"></script>
	<script>
		var QUESTIONS = document.getElementById("${cardList.get(0).secret_id}").id;
		var opt;
		switch(QUESTIONS){
		case'1':
			opt = document.querySelector('option[value="1"]');
			break;
		case'2':
			opt = document.querySelector('option[value="2"]');
			break;
		case'3':
			opt = document.querySelector('option[value="3"]');
			break;
		case'4':
			opt = document.querySelector('option[value="4"]');
			break;
		case'5':
			opt = document.querySelector('option[value="5"]');
			break;
		}
		opt.selected = true;
	</script>
</body>
</html>