<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>みんなの気持ち教えてくだサイト</title>
</head>
<body>

<h1>顔文字投稿</h1>

<!-- ここにアンケート名を表示 -->



<h2>理解度</h2>

<form method="POST" action="???">

<input type="radio" name="face" value="1" checked />ニコニコ
<input type="radio" name="face" value="2" />普通
<input type="radio" name="face" value="2" />不安

<input type="submit" value="登録" />
<!-- 理解度顔文字を表示 -->
	<h3>顔文字１</h3>
	<input type="radio" name="face" value="1" checked />ニコニコ

	<h3>顔文字２</h3>
	<input type="radio" name="face" value="2" />普通
	<h3>顔文字３</h3>
	<input type="radio" name="face" value="2" />不安


<input type="text" name="c_comprehension_text">

<h2>メンタル</h2>

<!--メンタル顔文字を表示  -->
	<h3>顔文字１</h3>


	<h3>顔文字２</h3>

	<h3>顔文字３</h3>

<input type="text" name="c_mental_text">

<form method = "post" action="???">
<input type="submit" name ="push" value="送信">
</body>
</html>