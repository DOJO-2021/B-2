<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>みんなの気持ち教えてくだサイト</title>
<link rel ="stylesheet" href ="css/passwordreset.css">
<link rel ="stylesheet" href ="css/common.css">

</head>
<body>
	<header class ="header">
	<h1 class ="logo"><img src ="images/logover_4.PNG" alt ="みんなの気持ち教えてくだサイト" class ="images"></h1>
	</header>
	<main>
	<hr>
		<div class ="box">
		<h2 class ="boxtitle">パスワード再設定</h2>
			<form method="POST" action="/CAP/PasswordResetServlet">
			<table class="form">
				<tr><th>新しいパスワード</th><td><input type="password" name="USER_PASSWORD1" placeholder="半角英数字6文字以上20文字以下"></td></tr>
				<tr><th>パスワード確認用</th><td><input type="password" name="USER_PASSWORD2"></td></tr>
		</table>


	<input type="submit" name="reset" value="パスワードを再設定" class="rstbtn">
			</form>
		</div>
	<footer class ="footer">
	<br>
	<br>
		<a href="S_MenuServlet.java">ホームに戻る</a>
		<p class ="copyright">&copy:Copyright MINNKUDA . All rights reserved.</p>
	</footer>
	</main>
</body>

</html>