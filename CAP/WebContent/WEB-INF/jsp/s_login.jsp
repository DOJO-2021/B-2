<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/CAP/css/s_login.css">
 <link rel="stylesheet" href="/CAP/css/common.css">
    <link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">

</head>
<body>


<form method="POST" action="/CAP/S_LoginServlet" >
<table class="form">
<tr>
<th>氏名</th>
<td><input type="text" name="user_l_name"><input type="text" name="user_f_name"></td>
</tr>
<tr>
<th>PW</th>
<td><input id="js-password" type="password" name="user_password">
  <span id="buttonEye" class="fa fa-eye-slash" onclick="pushHideButton()"></span></td>
</tr>
</table>

<input class="login1"type="submit" name="LOGIN" value="ログイン">
<input class="login1"type="reset" name="RESET" value="リセット">
</form>

<p>――――――――サインインが済んでいない方――――――――</p>
<div class = login2>
<a href="/CAP/SigninServlet" class="sign">サインイン</a><br>
<a href="/CAP/PasswordForgetServlet" class="pass">パスワードを忘れたら</a>
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