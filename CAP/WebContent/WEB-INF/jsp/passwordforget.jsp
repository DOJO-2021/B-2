<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<p>パスワードを忘れた方</p>
			<form method="POST" action="/CAP/PasswordForgetServlet">
				<table>
					<tr>
						<th>氏名</th><td><input type="text" name="L_NAME"></td><td><input type="text" name="F_NAME"></td>
					</tr>
					<tr>
						<th>秘密の質問</th>
						<td><select name="SECRET_NUM">
							<option value="1">出身地は？</option>
							<option value="2">親の旧姓</option>
							<option value="3">ペットの名前</option>
							<option value="4">母校（小学校）の名称</option>
							<option value="5">初めての海外旅行先は？</option></select></td>
					</tr>
					<tr>
						<th>答え<th><td><input type="text" name="ANSWER"></td>
					</tr>
				</table>
				<input type="submit" name="OK" value="OK">
				<input type="reset" value="リセット">
				<a href="/CAP/S_LoginServlet.java">ログインへ戻る</a>
			</form>
	</main>
</body>
</html>