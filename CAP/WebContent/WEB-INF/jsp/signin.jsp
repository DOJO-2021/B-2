<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

//みんなの気持ち教えてくだサイト

<form method="POST" action="/simpleBC/LoginServlet" id="form">
氏名<input  type="text" name="l_name" placeholder="英字以外で入力してください">
	<input type="text" name="f_name"><br>
PW<input id="password" type="password" name="PW" placeholder="英数字6文字以上20文字以下"><br>
秘密の質問<select name="secret_questions">
	<option value="questions1">あなたの出身地は？</option>
	<option value="questions2">親の旧姓は？</option>
	<option value="questions3">ペットの名前は？</option>
	<option value="questions4">母校（小学校）の名前は？</option>
	<option value="questions5">初めての海外旅行先は？</option>
</select><br>
こたえ<input type="text" name="answer"><br>
合言葉<input type="text" name="word"><br>
</form>
<p id="output"></p>

<input class=""type="submit" name="REGIST" value="登録">
<input class=""type="submit" name="RESET" value="リセット"><br>

<a href="/CAP/S_LoginServlet">受講生ログイン画面へ戻る</a>
<a href="/CAP/T_LoginServlet">講師ログイン画面へ戻る</a>

</body>
</html>