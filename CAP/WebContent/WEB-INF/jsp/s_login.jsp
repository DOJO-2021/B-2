<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="/CAP/css/s_login.css">
 <link rel="stylesheet" href="/CAP/css/common.css">
    <link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">

</head>
<body>
<a href="S_MenuServlet"><img src ="images/logover_4.PNG" alt ="みんなの気持ち教えてくだサイト" class="images"></a>

<div class="box">
		<p class="boxtitle">ログイン</p>
<form method="POST" action="/CAP/S_LoginServlet" >
<table class="form">
<tr>
<td><input type="text" name="user_l_name" placeholder="姓"><input type="text" name="user_f_name" placeholder="名"></td>
</tr>
<tr>
<td><input id="js-password" type="password" name="user_password" placeholder="PW (英数字6文字以上20文字以下)">
  <span id="buttonEye" class="fa fa-eye-slash" onclick="pushHideButton()"></span></td>
</tr>
</table>

<input class="login1"type="submit" name="LOGIN" value="ログイン">
<input class="login1"type="reset" name="RESET" value="リセット">
</form>

<p>―――――――サインインが済んでいない方―――――――</p>
<div class = login2>
<a href="/CAP/SigninServlet" ><button type="button" class="sign">サインイン</button> </a><br>
<a href="/CAP/PasswordForgetServlet" class="pass">パスワードを忘れた場合</a>
</div>
</div>
<script>
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
    </script>

</body>
<p id="output"></p>
</html>