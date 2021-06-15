<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<c:forEach var="i" items="${cardlist}" begin="1" end="2">
		<c:out value="${i}" />
		</c:forEach>さん</p>


					<form method="POST" action="/CAP/MyPageServlet">
						<table><c:forEach var="e" items="${cardList}" begin="3" end="5" step="1">
							<tr>
								<th>パスワード</th>
								<td><input type="password" name="PASSWORD" id="js-password" value="${e.user_password}"></td>
							</tr>
							<tr>
								<th>秘密の質問</th>
								<td><select name="QUESTIONS" value="${e.user_questions} ">
									<option value="questions1">出身地は？</option>
									<option value="questions2">親の旧姓は？</option>
									<option value="questions3">ペットの名前は？</option>
									<option value="questions4">母校（小学校）の名称は？</option>
									<option value="questions5">初めての海外旅行先は？</option></select></td>
							</tr>
							<tr>
								<th>答え<th><td><input type="text" name="ANSWER" value="${e.user_answer}"></td>
							</tr>
						</c:forEach>
						</table>
					</form>
			<input type="submit" name="OK" value="OK">
			<input type="reset" value="リセット">
			<a href="/CAP/S_MenuServlet.java">ホームに戻る</a>
	</main>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="/CAP/js/mypage.js"></script>
</body>
</html>