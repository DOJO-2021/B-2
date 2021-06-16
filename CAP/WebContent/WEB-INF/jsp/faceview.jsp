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
	margin-left:5%;
	overflow:auto;
}
 /* ジャンルは余白無しで詰める*/
ul{
	margin:0 0 0 0;
	padding:0 0 0 0;
}
/* ジャンルのタグ。点無しで中央揃え*/
.tag{
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
.tag:hover{
	background:#d3d3d3;
}
 /* 投稿*/
.text li{
	border-bottom:dashed 2px #F5F5F5;
	padding-left:5%;
	list-style:none;
}
 /* 投稿タイトル*/
h1{
	text-align: center;
}

h2{
	position:sticky;
	top:0;
	margin-top:0;
	height:36px;
	text-align:center;
	background:#ffffff;
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
/*ラジオボタンの〇ポチ消す*/
input[type="radio"]{
	display:none;
}
/* ジャンル選択時に暗くする*/
input[type="radio"]:checked + label{
	background:#d3d3d3;
}
</style>

</head>
<body>

<h1>顔文字集計</h1>

<!-- ヘッダーメニュー -->

<div class = "wrapper1">
	<div class = "wrapper2">
			<ul>

					<li><input type="radio" name="genre" value="1" id="ALL"><label for="ALL" class="tag">全体</label></li>
					<li><input type="radio" name="genre" value="2" id=""><label for="rikaido"  class="tag">理解度（個人）</label></li>
					<li><input type="radio" name="genre" value="3" id="Java"><label for="kimoti" class="tag">気持ち（個人）</label></li>



			</ul>
	</div>
	<div class = wrapper3>
		<h2></h2>
	</div>
</div>

<h2>理解度</h2>

<!-- 理解度データ表示 -->

<h2>メンタル</h2>
<!-- 理解度データ表示 -->


  <br>
  <footer>
	<ul class ="footerMenu">
		<li><a href="">ログアウト</a></li>
	</ul>
  </footer>

</body>
</html>