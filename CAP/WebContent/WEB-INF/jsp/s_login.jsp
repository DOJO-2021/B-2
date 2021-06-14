<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/CAP/css/s_login.css">
</head>
<body>


<form method="POST" action="/CAP/S_LoginServlet" id="form">
氏名<input type="text" name="user_l_name"><input type="text" name="user_f_name"><br>
PW<input type="password" name="user_password"><br>
</form>
<p id="output"></p>

<input class="login1"type="submit" name="LOGIN" value="ログイン">
<input class="login1"type="reset" name="RESET" value="リセット">
<br>
<a href="/CAP/T_LoginServlet"><input class="login2" type="submit" name="KOUSHI" value="講師の方はこちら"></a>
<a href="/CAP/SgininServlet"><input class="login2" type="submit" name="SIGNIN" value="サインイン"></a>
<a href="/CAP/PasswordForgetServlet"><input class="login2" type="submit" name="LOGIN" value="パスワードを忘れたら"></a>

</body>
</html>