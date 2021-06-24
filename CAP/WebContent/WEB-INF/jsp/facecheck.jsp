<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>みんなの気持ち教えてくだサイト</title>
<link rel ="stylesheet" href ="css/common.css">
<link rel ="stylesheet" href ="css/facecheck.css">
</head>
<body>
<header class="header">
			<a href="${menu.menu}"><img src="images/logo5.png" alt="みんなの気持ち教えてくだサイト""></a>
</header>


<!--<div class = "wrapper1">-->
	<form method="POST" action="FaceCheckServlet">
		 <div class="q">
		 <p class="qtitle">ここにアンケート名を入力<br></p>
		 <input type="text" class="questionnaire" name="Q_NAME" >

					<p></p>
					<p></p>

	<%--  				<div class = "item1">

							<h3>理解度</h3>




								<!-- 理解度顔文字を表示 -->
								<!--<h4>顔文字１</h4>-->
								<div class="center">
									<input type="radio" name="face1" value="1"required>ニコニコ

									<!--<h4>顔文字２</h4>-->
									<input type="radio" name="face1" value="2">普通
									<!--<h4>顔文字３</h4>-->
									<input type="radio" name="face1" value="3">不安

								<br>
								 <input type="text"class="c_text" name="C_COMPREHENSION_TEXT">
								</div>
					</div>




					<div class = "item2">

								<h3>メンタル</h3>

								<!--メンタル顔文字を表示  -->
								<!--<h4>顔文字１</h4>-->
								<div class="center">
									<input type="radio" name="face2" value="1" required>ニコニコ

								<!--<h4>顔文字２</h4>-->
									<input type="radio" name="face2" value="2">普通
								<!--<h4>顔文字３</h4>-->
									<input type="radio" name="face2" value="3">不安

									<br>
									<input type="text"class="c_text" name="C_MENTAL_TEXT">
								</div>

					</div>

				 <br> --%>
				 <br>
				 <div class = "wrapper3">
				 	 <input class="send" type="submit" name="push" value="送信">
		</div>
				 </div>
	</form>


<!--</div>-->
<footer class ="footer2">
<p class="left"><a href="/CAP/LogoutServlet">ログアウト</a></p>
<p class="right"><a href="/CAP/T_menuServlet">メニュー</a></p>
</footer>
<p class ="copyright">&copy:Copyright MINNKUDA . All rights reserved.</p>

</body>
</html>