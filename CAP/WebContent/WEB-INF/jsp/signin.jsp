<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/CAP/css/signin.css">
    <link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">


</head>
<body>



<form method="POST" action="/CAP/SigninServlet" class="form">

<p>氏名<input  type="text" name="user_l_name" placeholder="英字以外で入力してください">
	<input type="text" name="user_f_name"><br>
PW<input id="js-password" type="password" name="user_password" placeholder="英数字6文字以上20文字以下">
  <span id="buttonEye" class="fa fa-eye-slash" onclick="pushHideButton()"></span><br>
秘密の質問<select name="secret_id">
	<option value="1">①出身地は？</option>
	<option value="2">②親の旧姓は？</option>
	<option value="3">③ペットの名前は？</option>
	<option value="4">④母校（小学校）の名前は？</option>
	<option value="5">⑤初めての海外旅行先は？</option>
</select><br>
こたえ<input type="text" name="user_answer"><br>
合言葉<input type="text" name="user_word"><br>
<input type ="radio" name ="user_type" value="1" checked>受講生
<input type ="radio" name ="user_type" value="2" >講師
<br>

<input class="regist"type="submit" name="REGIST" value="登録">
<input type="reset" name="RESET" value="リセット"><br></p>
</form>
<div class = signin1>
<a href="/CAP/S_LoginServlet">ログイン画面へ戻る</a></div>

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
</html>