<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>みんなの気持ち教えてくだサイト</title>
<link rel="stylesheet" href="/CAP/css/passwordreset.css">
<link rel="stylesheet" href="/CAP/css/common.css">

</head>
<body>
	<header class="header"></header>
	<main>
		<div class="box">
			<h2 class="boxtitle">-パスワード再設定(変更)-</h2>
			<form method="POST" action="/CAP/PasswordResetServlet">
				<table class="form">
					<tr>
						<th>新しいPW</th>
						<td><input type="password" name="USER_PASSWORD1"
							placeholder="半角英数字6文字以上20文字以下"></td>
					</tr>
					<tr>
						<th>新しいPW(確認)</th>
						<td><input type="password" name="USER_PASSWORD2"></td>
					</tr>
				</table>
				<br>
				<input type="submit" name="reset" value="OK" class="pass1">
				<input type="submit" name="reset" value="リセット" class="pass1"><br>
							 <a href="/CAP/S_LoginServlet">ログインへ戻る</a>
			</form>
		</div>
		<footer class="footer">
					</footer>
	</main>
</body>
<p class="copyright">&copy:Copyright MINNKUDA . All rights
				reserved.</p>

</html>