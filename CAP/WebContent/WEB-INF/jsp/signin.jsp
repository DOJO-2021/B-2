<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>みんなの気持ち教えてくだサイト</title>
<link rel="stylesheet" href="css/signin.css">
<link rel="stylesheet" href="css/common.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	rel="stylesheet">
</head>
<body>
	<header class="header"> </header>
	<main>
		<div class="box">
			<p class="boxtitle">-SIGNIN-</p>
			<form method="POST" action="/CAP/SigninServlet" id="form">
				<table class="form">
					<tr>
						<th>氏名</th>
						<td><input type="text" name="user_l_name"
							placeholder="姓(英字以外)"> <input type="text"
							name="user_f_name" placeholder="名(英字以外)"></td>
					</tr>
					<tr>
						<th>PW</th>
						<td><input id="js-password" type="password"
							name="user_password" placeholder="英数字6文字以上20文字以下"></td>
						<td><span id="buttonEye" class="fa fa-eye"
							onclick="pushHideButton()"></span></td>
					</tr>
					<tr>
						<th>秘密の質問</th>
						<td><select name="secret_id">
								<option value="1">①出身地は？</option>
								<option value="2">②親の旧姓は？</option>
								<option value="3">③ペットの名前は？</option>
								<option value="4">④母校（小学校）の名前は？</option>
								<option value="5">⑤初めての海外旅行先は？</option>
						</select></td>
					</tr>
					<tr>
						<th>答え</th>
						<td><input type="text" name="user_answer"></td>
					</tr>
					<tr>
						<th>合言葉</th>
						<td><input type="text" name="user_word"></td>
					<tr>
						<th></th>
						<td><input type="radio" name="user_type" value="1" checked>受講生
							<input type="radio" name="user_type" value="2">講師
							(選択してください)</td>
					</tr>
					</table>
				<br> <input class="signin1" type="submit" name="REGIST"
					value="登録"> <input class="signin1" type="reset"
					name="RESET" value="リセット"><br> <a
					href="/CAP/S_LoginServlet">ログイン画面へ戻る</a>
			</form>
		</div>
	</main>
	<p class="copyright">&copyCopyright MINNKUDA . All rights reserved.</p>
	<script>
		function pushHideButton() {
			var txtPass = document.getElementById("js-password");
			var btnEye = document.getElementById("buttonEye");
			if (txtPass.type === "text") {
				txtPass.type = "password";
				btnEye.className = "fa fa-eye";
			} else {
				txtPass.type = "text";
				btnEye.className = "fa fa-eye-slash";
			}
		}
	</script>
</body>
</html>