<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>みんくだ</title>
<link rel="stylesheet" href="/CAP/css/s_login.css">
<link rel="stylesheet" href="/CAP/css/common.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	rel="stylesheet">
</head>

<body>
	<header class="header">
		<a href="S_MenuServlet" class="images"></a>
	</header>

	<div class="box">
		<p class="boxtitle">-LOGIN-</p>
		<form method="POST" action="/CAP/S_LoginServlet" id="form">
			<table class="form">
				<tr>
					<td><input type="text" name="user_l_name" placeholder="姓"><input
						type="text" name="user_f_name" placeholder="名"></td>
				</tr>
				<tr>
					<td><input id="js-password" type="password"
						name="user_password" placeholder="PW (半角英数字6文字以上20文字以下)"> <span
						id="buttonEye" class="fa fa-eye-slash" onclick="pushHideButton()"></span></td>
				</tr>
			</table>

			<input class="login1" type="submit" name="LOGIN" value="ログイン">
			<input class="login1" type="reset" name="RESET" value="リセット">
		</form>
		<p id="output"></p>

		<p>――――――サインアップが済んでいない方――――――</p>
		<div class=login2>
			<a href="/CAP/SigninServlet"><button type="button" class="sign">サインアップ</button>
			</a><br> <a href="/CAP/PasswordForgetServlet" class="pass">パスワードを忘れた場合</a>
			<br>
		</div>
	</div>
	<p class="copyright">&copyCopyright MINNKUDA . All rights
		reserved.</p>
	<script>
	'use strict';
		function pushHideButton() {
			var txtPass = document.getElementById("js-password");
			var btnEye = document.getElementById("buttonEye");
			if (txtPass.type === "text") {
				txtPass.type = "password";
				btnEye.className = "fa fa-eye-slash";
			} else {
				txtPass.type = "text";
				btnEye.className = "fa fa-eye";
			}
		}

		/* submitボタンが押されたら「クリックされました」というメッセージを表示 */

		document.getElementById('form').onsubmit = function(event){
		const user_l_name = document.getElementById('form').user_l_name.value;
		const user_f_name = document.getElementById('form').user_f_name.value;
		const user_password = document.getElementById('form').user_password.value;
		console.log(user_l_name);
		console.log(user_f_name);
		console.log(user_password);
		if(user_l_name === "" || user_f_name === "" || user_password === ""){
			event.preventDefault();
		document.getElementById('output').textContent = '※氏名とパスワードを入力してください';
		}
		};
	</script>
</body>
</html>