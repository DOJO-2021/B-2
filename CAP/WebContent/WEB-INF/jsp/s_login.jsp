<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/CAP/css/s_login.css">
    <link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">

</head>
<body>


<form method="POST" action="/CAP/S_LoginServlet" class="form">
<p>氏名<input type="text" name="user_l_name"><input type="text" name="user_f_name"><br>
PW<input id="js-password" type="password" name="user_password">
  <span id="buttonEye" class="fa fa-eye-slash" onclick="pushHideButton()"></span><br>

<input class="login1"type="submit" name="LOGIN" value="ログイン">
<input class="login1"type="reset" name="RESET" value="リセット"></p><br>
</form>

<div class = login2>
<a href="/CAP/SigninServlet"><input  type="submit" name="SIGNIN" value="サインイン"></a>
<a href="/CAP/PasswordForgetServlet"><input type="submit" name="LOGIN" value="パスワードを忘れたら"></a>
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