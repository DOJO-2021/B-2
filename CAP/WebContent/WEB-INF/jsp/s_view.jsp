<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>つぶやき投稿閲覧＜受講生用＞</title>
</head>
<body>
  <header>
		<h1>つぶやき投稿閲覧</h1>
		<ul class="menu">
			<li><a href="">つぶやき投稿</a></li>
			<li><a href="">一覧</a></li>
		</ul><br>
  </header>
  <div class = "wrapper1">
	<div class = "wrapper2">
			<ul class="tag">
				<c:forEach var="" items="">
					<li>気持ち</li>
					<li>HTML／CSS</li>
					<li>Java</li>
					<li>JavaScript</li>
					<li>SQL</li>
					<li>質問・要望</li>
					<li>${.}</li>
				</c:forEach>
			</ul>
	</div>
	<div class = wrapper3>
		<h2>気持ち　投稿閲覧</h2>
			<ul class="text">
				<c:forEach var="" items="">
					<li><div id="menu-btn"></div>
						<div id="menu-content"><ul><li><a href="#">投稿削除</a></li></ul></div>
					${.time}<br>${.text}<br>${.stamp}<br><button id="js-show-popup">返信</button>
					</li>
					<li><div id="menu-btn"></div>
						<div id="menu-content"><ul><li><a href="#">投稿削除</a></li></ul></div>
					${.time}<br>${.text}<br>${.stamp}<br><button id="js-show-popup">返信</button>
					</li>
					<li><div id="menu-btn"></div>
						<div id="menu-content"><ul><li><a href="#">投稿削除</a></li></ul></div>
					${.time}<br>${.text}<br>${.stamp}<br><button id="js-show-popup">返信</button>
					</li>
					<li><div id="menu-btn"></div>
						<div id="menu-content"><ul><li><a href="#">投稿削除</a></li></ul></div>
					${.time}<br>${.text}<br>${.stamp}<br><button id="js-show-popup">返信</button>
					</li>
					<li><div id="menu-btn"></div>
						<div id="menu-content"><ul><li><a href="#">投稿削除</a></li></ul></div>
					${.time}<br>${.text}<br>${.stamp}<br><button id="js-show-popup">返信</button>
					</li>
					<li><div id="menu-btn"></div>
						<div id="menu-content"><ul><li><a href="#">投稿削除</a></li></ul></div>
					${.time}<br>${.text}<br>${.stamp}<br><button id="js-show-popup">返信</button>
					</li>
					<li><div id="menu-btn"></div>
						<div id="menu-content"><ul><li><a href="#">投稿削除</a></li></ul></div>
					${.time}<br>${.text}<br>${.stamp}<br><button id="js-show-popup">返信</button>
					</li>
					<li><div id="menu-btn"></div>
						<div id="menu-content"><ul><li><a href="#">投稿削除</a></li></ul></div>
					${.time}<br>${.text}<br>${.stamp}<br><button id="js-show-popup">返信</button>
					</li>
				</c:forEach>
			</ul>
	</div>
<!-ポップアップ->
	<div class="popup" id="js-popup">
  		<div class="popup-inner">
    		<div class="close-btn" id="js-close-btn">
				<i class="fas fa-times"></i>
			</div>
			<p>（投稿内容）</p><br>
			<c:forEach var="" items="">
				<p>${.comment}</p>
			</c:forEach>
			【コメント書き込み】
			<form method="POST" action="CAP/S_ViewServlet">
				<input type="textarea">
				<input type="submit" value="送信">
			</form>
 		</div>
  		<div class="black-background" id="js-black-bg"></div>
	</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
'use strict';

//jQuery無しでコメントオンオフ切り替え
const btn = document.getElementById("js-show-popup");
const closeBtn = document.getElementById('js-close-btn');
const popup = document.getElementById('js-popup');

btn.addEventListener('click',function(){
	popup.classList.toggle('is-show');
});

closeBtn.addEventListener('click',function(){
    popup.classList.toggle('is-show');
});

//jQueryでハンバーガーボタン切り替え
$(function(){
	$("#menu-btn").click(function(){
		$(this).toggleClass("on");
		$("#menu-content").toggleClass("menu-appearance");
	});
});
</script>
</div>

  <br>
  <footer>
	<ul class ="footerMenu">
		<li><a href="">ログアウト</a></li>
	</ul>
  </footer>
</body>
<link href="https://use.fontawesome.com/releases/v5.0.8/css/all.css" rel="stylesheet">
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
.tag li{
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
.tag li:hover{
	background:#d3d3d3;
}

/* 投稿*/
.text li{
	border-bottom:dashed 2px #f5f5f5;
	padding-left:5%;
	list-style:none;
}
/* ページタイトル*/
h1{
	text-align:center;
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
/* メニューの位置をタグと合わせる*/
.menu{
	max-width:960;
	margin:0 auto 0 auto;
}
/* メニューを横並びに*/
.menu li{
	display:inline;
	margin-right:10px;
	list-style:none;
}

/*メニューをホバーすると赤になる*/
.menu li:hover{
	color:red;
}

/* メニューを投稿の位置と合わせる*/
.footerMenu{
	max-width:960;
	margin:0 auto 0 auto;
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

/* ポップ表示時の全体画面*/
.popup {
  display:none;
  position: fixed;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  z-index: 9999;/*要素の優先度、大きいほど前へ*/
  opacity: 0;
  visibility: hidden;
  transition: 0.6s;
}

/*is-showがついたとき表示*/
.popup.is-show {
  display:inline;
  opacity: 1;
  visibility: visible;
}

/* ポップ画面の設定*/
.popup-inner {
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%,-50%);
  width: 80%;
  max-width: 600px;
  padding: 50px;
  background-color: #fff;
  z-index: 2;
}

/*ポップを閉じるボタンのデザイン */
.close-btn {
  position: absolute;
  right: 0;
  top: 0;
  width: 50px;
  height: 50px;
  line-height: 50px;
  text-align: center;
  cursor: pointer;
}
.close-btn i {
  font-size: 20px;
  color: #333;
}

/*ポップの後ろの背景を暗くする */
.black-background {
  position: absolute;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0,0,0,0.8);
  z-index: 1;
  cursor: pointer;
}

/* ハンバーガーボタン*/
#menu-btn{
	width: 30px;
	float:right;
}
#menu-btn::before{
	width: 20px;
    position:static;
	content: "≡";
	color: #000000;
	font-size: 20px;
	cursor: pointer;
}
/*ハンバーガーを押したらバツ印に変化*/
#menu-btn.on::before {
	content: "×";
}

/*投稿削除ボタンを隠す*/
#menu-content {
	display:none;
    width: 5em;
    height: 2em;
    position: static;
	float:right;
    top: 0;
    left: 0;
    z-index: 80;
	opacity: 0;
	visibility:hidden;
}
/*投稿削除ボタンを出現*/
#menu-content.menu-appearance{
	display:inline;
	opacity: 1;
	visibility: visible;
}

</style>
</html>