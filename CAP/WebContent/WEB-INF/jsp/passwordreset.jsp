<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
		<p>パスワード再設定</p>
		<form method="POST" action="/CAP/PasswordResetServlet.java">
			<table>
				<tr><th>新しいパスワード</th><td><input type="password" name="USER_PASSWORD" placeholder="半角英数字6文字以上20文字以下"></td></tr>
				<tr><th>パスワード確認用</th><td><input type="password" name="USER_PASSWORD"></td></tr>
			</table>
		</form>
	<input type="submit" name="RESET" value="パスワードを再設定">
	<a href="/CAP/S_LoginServlet.java">ログインへ戻る</a>
	</main>
</body>
</html>