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
		<form method="POST" action="/CAP/PasswordResetServlet">
			<table>
				<tr><th>新しいパスワード</th><td><input type="password" name="USER_PASSWORD1" placeholder="半角英数字6文字以上20文字以下"></td></tr>
				<tr><th>パスワード確認用</th><td><input type="password" name="USER_PASSWORD2"></td></tr>
			</table>
			<input type="submit" name="RESET" value="パスワードを再設定">
		</form>
	<a href="/CAP/S_LoginServlet">ログインへ戻る</a>
	</main>
</body>
</html>