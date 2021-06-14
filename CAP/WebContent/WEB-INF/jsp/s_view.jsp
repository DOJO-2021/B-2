<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/CAP/css/s_view.css" type="text/css">
<link href="https://use.fontawesome.com/releases/v5.0.8/css/all.css" rel="stylesheet"  type="text/css">
<title>つぶやき投稿閲覧＜受講生用＞</title>
</head>
<body>
  <header>
		<h1>つぶやき投稿閲覧</h1>
		<ul class="menu">
			<li><a href="/CAP/S_PostServlet">つぶやき投稿</a></li>
			<li><a href="/CAP/S_MenuServlet">一覧</a></li>
		</ul><br>
  </header>
  <div class = "wrapper1">
	<div class = "wrapper2">
			<ul>
				<c:forEach var="a" items="${GenreList}">
					<li>
						<input type="radio" name="genre" value="${a.genre_id}" id="${a.genre_id}">
						<label for="${a.genre_id}" class="tag">${a.genre_name}</label>
					</li>
				</c:forEach>
			</ul>
	</div>
	<div class = wrapper3>
		<h2>気持ち　投稿閲覧</h2>
			<ul class="text">
				<c:forEach var="b" items="${PostList}">
					<c:forEach var="c" items="${StampList}">
						<li><div id="menu-btn"></div>
							<div id="menu-content"><ul><li><a href="#">投稿削除</a></li></ul></div>
						${b.post_date} - ${b.post_time}<br>${b.post_text}<br>${c.browsing_b_stamp}<br>
						<button id="js-show-popup">返信</button>
						</li>
					</c:forEach>
				</c:forEach>
			</ul>
	</div>

	<div class="popup" id="js-popup">
  		<div class="popup-inner">
    		<div class="close-btn" id="js-close-btn">
				<i class="fas fa-times"></i>
			</div>
			<p>（投稿内容）</p><br>
			<c:forEach var="d" items="${CommentList}">
				<p>${d.browsing_c_comment}</p>
			</c:forEach>
			【コメント書き込み】
			<form method="POST" action="CAP/S_ViewServlet">
				<input type="text" name="comment">
				<input type="submit" value="送信">
			</form>
 		</div>
  		<div class="black-background" id="js-black-bg"></div>
	</div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/CAP/js/s_view.js"></script>
  <br>
  <footer>
	<ul class ="footerMenu">
		<li><a href="">ログアウト</a></li>
	</ul>
  </footer>
</body>
</html>