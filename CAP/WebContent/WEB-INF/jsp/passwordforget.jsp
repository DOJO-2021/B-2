<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html style="height: 300px;">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/CAP/css/passwordforget.css">
<link rel="stylesheet" href="/CAP/css/common.css">
<title>みんなの気持ち教えてくだサイト</title>
</head>
<body>
	<header class ="header">
		<h1 class="logo"><img src="images/logover_4.PNG" alt ="みんなの気持ち教えてくだサイト" class="images"></h1>
	</header>
	<hr>
	<main>
	<div class="box">
		<p class="boxtitle">パスワードを忘れた方</p>
			<form method="POST" action="/CAP/PasswordForgetServlet">
			<table class="form">
					<tr>
					<th>氏名</th><td><input type="text" name="l_name" style="width:75px;"></td><td><input type="text" name="f_name" style="width:75px;"></td>
					</tr>
					<tr>
						<th>秘密の質問</th>
						<td><select name="QUESTIONS"style="width:163px;">
							<option value="1">出身地は？</option>
							<option value="2">親の旧姓</option>
							<option value="3">ペットの名前</option>
							<option value="4">母校（小学校）の名称</option>
							<option value="5">初めての海外旅行先は？</option></select></td>
						</tr>
					<tr>
						<th>答え</th><td><input type="text" name="answer" style="width:163px;"></td>
					</tr>
				</table>
				<table>
					<tr>
						<td><input type="submit" name="ok" value="OK" class="okbtn"></td>
						<td><input type="submit" name="reset" value="リセット" class="resetbtn"></td>
					</tr>
				</table>
			</form>
	</div>
	</main>
	</body>
	<footer class="footer">
	<br>
		<a href="S_LoginServlet.java">戻る</a>
				<p class="copyright">&copy:Copyright MINNKUDA . All rights reserved.</p>
	</footer>

</html>