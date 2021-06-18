<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>サイト</title>
<link rel="stylesheet" href="/CAP/css/s_post.css">
</head>
<body>
<header class ="header">
<h1 class ="logo"><a href="s_MenuServlet"><img src ="images/header.png" alt ="みんなの気持ち教えてくだサイト"></a></h1>
</header>
<hr>


<script type="text/javascript" src="/CAP/js/s_post.js"></script>






	<h1>つぶやき投稿機能</h1>
	<h2>つぶやきフォーム</h2>
	<form method="POST" action="/CAP/S_PostServlet" name="postform" id="Postform">
		<div class="wrapper1">


			<div class="wrapper2">

			<ul>
				<c:forEach var="a" items="${GenreList}">
					<li>
						<input type="radio" name="genre" id="${a.genre_id}" value="${a.genre_id}" required="required">
						<label for="${a.genre_id}" class="tag">${a.genre_name}</label>
					</li>
				</c:forEach>
			</ul>
			</div>
			<div class=wrapper3>
				<textarea class="question" name="post_text" required="required"></textarea>
				<br>
				<div id="submit">
					<input type="submit" name="POST_TEXT" value="投稿" >
				</div>
			</div>

		</div>
	</form>

</body>
<footer class ="footer">
	<ul class="footerMenu">
		<li><a href="/CAP/LogoutServlet">ログアウト</a> <a href="/CAP/S_MenuServlet">戻る</a></li>

	</ul>

</footer>



</html>

