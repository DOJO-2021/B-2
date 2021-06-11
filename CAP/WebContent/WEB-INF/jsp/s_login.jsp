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


<form method="POST" action="/simpleBC/LoginServlet" id="form">
氏名<input type="text" name="l_name"><input type="text" name="f_name"><br>
PW<input type="password" name="PW"><br>
</form>
<p id="output"></p>

<input class="login1"type="submit" name="LOGIN" value="ログイン">
<input class="login1"type="submit" name="RESET" value="リセット">
<br>
<input class="login2"type="submit" name="KOUSHI" value="講師の方はこちら">
<input class="login2"type="submit" name="SIGNIN" value="サインイン">
<input class="login2"type="submit" name="LOGIN" value="パスワードを忘れたら">



</body>
</html>