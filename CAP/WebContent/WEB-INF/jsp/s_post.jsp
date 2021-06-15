<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>サイト</title>


</head>

<body>
<h1>つぶやき投稿機能</h1>
	<h2>書き込むエリア</h2>
<div class = "wrapper1">
	<form method="POST" action="/CAP/S_PostServlet" name="postform" id="Postform">
		<div class = "wrapper2">
			<ul>

						<li><input type="radio" name="genre" value="1" id="mind"><label for="mind" class="tag">気持ち</label></li>
						<li><input type="radio" name="genre" value="2" id="HTML/CSS"><label for="HTML/CSS"  class="tag">HTML／CSS</label></li>
						<li><input type="radio" name="genre" value="3" id="Java"><label for="Java" class="tag">Java</label></li>
						<li><input type="radio" name="genre" value="4" id="JavaScript"><label for="JavaScript" class="tag">JavaScript</label></li>
						<li><input type="radio" name="genre" value="5" id="SQL"><label for="SQL" class="tag">SQL</label></li>
						<li><input type="radio" name="genre" value="6" id="Q"><label for="Q" class="tag">質問・要望</label></li>

	<%--
						<li><input type="radio" name="genre" value="7" id="${.}"><label for="${.}" class="tag">${.}</label></li>
	 --%>
			</ul>
		</div>
		<div class = wrapper3>
			<textarea class="question" name="post_text"></textarea><br>
			<div id="submit">
	     	<input type="submit" name="POST_TEXT" value="投稿">

			</div>
		</div>
	</form>
</div>

</body>
<footer>
	<ul class ="footerMenu">
		<li><a href="">ログアウト</a></li>
	</ul>
  </footer>

  <%--
<style>
/* wrapper1はメイン画面*/
.wrapper1{
	display:flex;
	max-width:960px;
	max-height:400px;
	overflow:hidden;
	margin: 0 auto 0 auto;
	border:solid 3px;
}
 /* wrapper２はジャンルタグ一覧*/
.wrapper2{
	display:block;
	width: 20%;
	margin:0 0 0 0;
	overflow:auto;
	border-right:solid 2px;
}
 /* ジャンルのスクロールバーは消す*/
.wrapper2::-webkit-scrollbar {
    display:none;
  }
 /* wrapper３はコメント画面。*/
.wrapper3{
	display:block;
	width: 80%;
	overflow:hidden;


}


/* ジャンルは余白無しで詰める*/
ul{
	margin:0 0 0 0;
	padding:0 0 0 0;
}
 /* ジャンルのタグ。点無しで中央揃え*/
.tag {
 /* 文字の中央配置*/
	display: flex;
	justify-content: center;
	align-items: center;
	text-align: center;
 /* 文字の大きさ*/
	font-size:150%;
 /* 外枠の設定*/
	list-style:none;
	margin-bottom:1px;
	border: solid 1px #000000;
	box-shadow:0 3px 6px rgba(0,0,0,0.25);
	background:#f5f5f5;
	height:75px;
}
 /*ホバーで色が濃くなる*/
.tag :hover{
	background:#d3d3d3;
}
/*ラジオボタンの〇ポチ消す*/
input[type="radio"]{
	display:none;
}
/* ジャンル選択時に暗くする*/
input[type="radio"]:checked + label{
	background:#d3d3d3;
}
 /* 投稿*/
.text li{
	border-bottom:dashed 2px #F5F5F5;
	padding-left:5%;
	list-style:none;
}
 /* 投稿タイトル*/
h2{
	position:sticky;
	top:0;
	margin-top:0;
	height:36px;
	text-align:center;
	background:#ffffff;
}
/* テキストエリア設定*/
.question{
	width: 100%;
	height: 90%;
	margin: 0 0 0 0;
	border: none;
	resize: none;
	outline: none;
}
/*ボタン*/
div#submit{
	width: 42px;
	margin: 0 auto 0 auto;
}
/* フッターメニューを右に移動*/
.footerMenu li{
	text-align:right;
	list-style:none;
}
 /*フッターメニューをホバーすると赤になる*/
.footerMenu li:hover{
	color:red;
}

</style>
--%>
</html>

