<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>サイト</title>
<link rel="stylesheet" href="/CAP/css/s_post.css">
</head>
<body>
<header class ="header">
<h1 class ="logo"><a href="S_MenuServlet"><img src ="images/" alt ="みんなの気持ち教えてくだサイト"></a></h1>
</header>
<hr>


<script type="text/javascript" src="/CAP/js/s_post.js"></script>






	<h1>つぶやき投稿機能</h1>
	<h2>つぶやきフォーム</h2>
	<form method="POST" action="/CAP/S_PostServlet" name="postform" onSubmit="return check()"
		id="Postform">
		<div class="wrapper1">


			<div class="wrapper2">

				<ul>

					<li><input type="radio" name="genre" value="1" id="mind" required="required" checked="checked" ><label for="mind" class="tag">気持ち</label></li>
					<li><input type="radio" name="genre" value="2" id="HTML/CSS"><label
						for="HTML/CSS" class="tag">HTML／CSS</label></li>
					<li><input type="radio" name="genre" value="3" id="Java"><label
						for="Java" class="tag">Java</label></li>
					<li><input type="radio" name="genre" value="4" id="JavaScript"><label
						for="JavaScript" class="tag">JavaScript</label></li>
					<li><input type="radio" name="genre" value="5" id="SQL"><label
						for="SQL" class="tag">SQL</label></li>
					<li><input type="radio" name="genre" value="6" id="Q"><label
						for="Q" class="tag">質問・要望</label></li>


					<%--
						<li><input type="radio" name="genre" value="7" id="${.}"><label for="${.}" class="tag">${.}</label></li>
	 --%>
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

