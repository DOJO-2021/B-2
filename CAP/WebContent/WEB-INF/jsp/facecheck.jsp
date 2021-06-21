<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>みんなの気持ち教えてくだサイト</title>

<style>
/* wrapper1はメイン画面*/
.wrapper1{

	max-width:960px;
	max-height:1200px;
	overflow:hidden;
	margin: 0 auto 0 auto;
	border:solid 3px;
}
 /* item1は理解度*/
.item1{
	display:block;
	width: 45%;
	height:400px;
	margin:0 0 0 60;
	overflow:auto;
	border:solid 2px;
	float:left;
}

 /* item2は理解度*/
.item2{
	display:block;
	width: 45%;
	height:400px;
	margin:0 60 0 0;
	overflow:auto;
	border:solid 2px;
	float:right;
}

/* wrapper３はコメント画面。*/
.wrapper3{
	display:block;
	width: 30%;
	margin:0 auto;
	overflow:auto;
	clear:both;
}
/*テキストボックス*/
.c_text{
	display:block;
	width: 400px;
	height:300px;
	margin:0 0 0 0 ;
	width:90%;
	height:60%;

}
.questionnaire{
	width:100px;
	heigt:100px;
}

/*送信ボタン*/

h1{
	text-align: center;
}

h2{
	text-align: center;
}

h3{
	text-align: center;
}

label {
  display: block; /* ブロックを作るように */
  margin: 5px 0; /* 前後のスペース */
}

.center{
	margin:0 auto;
	width:80%;
	text-align: center;
	}
/*input[type="text"]{
	width:90%;
	height:60%;
}*/

</style>

</head>
<body>

<h1>顔文字投稿</h1>

<p><a href="/CAP/T_MenuServlet">メニュー</a></p>
<!--<div class = "wrapper1">-->
	<form method="POST" action="FaceCheckServlet">
		<input type="text" class="questionnaire" name="Q_NAME"> ここにアンケート名を入力

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
				 	 <input type="submit" style="width: 400px; height: 50px;" name="push" value="送信">
				 </div>
	</form>


<!--</div>-->
<p><a href="/CAP/LogoutServlet">ログアウト</a></p>
</body>
</html>