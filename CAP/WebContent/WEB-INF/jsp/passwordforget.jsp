<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/CAP/css/passwordforget.css">
<link rel="stylesheet" href="/CAP/css/common.css">
<title>みんなの気持ち教えてくだサイト</title>
</head>
<body>
	<header class="header"> </header>
	<main>
		<div class="box">
			<p class="boxtitle">-パスワード再設定(認証)-</p>
			<form method="POST" action="/CAP/PasswordForgetServlet">
				<table class="form">
					<tr>
						<th>氏名</th>
						<td><input type="text" name="l_name">
						<input type="text" name="f_name"></td>
					</tr>
					<tr>
						<th>秘密の質問</th>
						<td><select name="QUESTIONS">
								<option value="1">①出身地は？</option>
								<option value="2">②親の旧姓は？</option>
								<option value="3">③ペットの名前は？</option>
								<option value="4">④母校（小学校）の名前は？</option>
								<option value="5">⑤初めての海外旅行先は？</option>
						</select></td>
					</tr>
					<tr>
						<th>答え</th>
						<td><input type="text" name="answer"></td>
					</tr>
				</table>
				<br>
				<input type="submit" name="ok" value="OK" class="pass1">
				<input type="submit" name="reset" value="リセット" class="pass1"><br>
				<a href="/CAP/S_LoginServlet">ログインへ戻る</a>
			</form>
		</div>
	</main>
</body>
	<p class="copyright">&copyCopyright MINNKUDA . All rights
		reserved.</p>

</html>