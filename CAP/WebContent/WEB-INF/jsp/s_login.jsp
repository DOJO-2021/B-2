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


<form method="POST" action="/CAP/S_LoginServlet" id="form">
氏名<input type="text" name="user_l_name"><input type="text" name="user_f_name"><br>
PW<input id="js-password" type="password" name="user_password">
  <span id="buttonEye" class="fa fa-eye" onclick="pushHideButton()"></span><br>

<p id="output"></p>

<input class="login1"type="submit" name="LOGIN" value="ログイン">
<input class="login1"type="reset" name="RESET" value="リセット"><br>
</form>

<a href="/CAP/SigninServlet"><input class="login2" type="submit" name="SIGNIN" value="サインイン"></a>
<a href="/CAP/PasswordForgetServlet"><input class="login2" type="submit" name="LOGIN" value="パスワードを忘れたら"></a>

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