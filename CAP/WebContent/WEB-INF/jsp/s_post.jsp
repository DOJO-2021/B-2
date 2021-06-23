<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="/CAP/js/s_post.js"></script>

<title>みんくだ</title>
<link rel="icon" href="letter.ico">
<link rel="stylesheet" href="/CAP/css/s_post.css">
<link rel="stylesheet" href="/CAP/css/common.css">
</head>
<main>
<header class ="header">
		<h1>
<a href="${menu.menu}"><img src="images/logo5.png" alt="みんなの気持ち教えてくだサイト" class="images"></a>
		</h1>
</header>
<ul id="g-nav">
			<li class="nav-item"><a href="/CAP/S_PostServlet">つぶやき投稿</a></li>
			<li class="nav-item"><a href="/CAP/S_ViewServlet">　　一覧　　</a></li>
			 <li class="nav-item"><a href="/CAP/S_MenuServlet">トップページ</a></li>

</ul>

<body>

<br>
<br>
	<h2>つぶやきフォーム</h2>
<br>
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


				</ul>
			</div>
			<div class=wrapper3>
				<textarea class="question" name="post_text" required="required"></textarea>
				<br>
				<div id="submit">
					<input type="submit" name="POST_TEXT" value="投稿" class="btn">
				</div>
			</div>

		</div>
	</form>


</main>

	<footer class="footer2">
		<div class="left"><a href="/CAP/LogoutServlet">ログアウト</a></div>
		<div class="right"><a href="/CAP/S_MenuServlet">戻る</a></div>
		 </footer>
	<p class="copyright">&copy:Copyright MINNKUDA . All rights reserved.</p>


</body>



</html>

