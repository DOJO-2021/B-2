<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!--<meta charset="UTF-8">-->
<title>みんくだ-講師用-</title>
<link rel ="stylesheet" href ="css/t_menu.css">
<link rel ="stylesheet" href ="css/common.css">
</head>
<body>
<header>
			<a href="${menu.menu}"><img src="images/logo5.png" alt="みんなの気持ち教えてくだサイト" class="images"></a>
</header>
<hr>
<a class="sai" href="/CAP/MyPageServlet"><img src ="images/icon.png" alt ="アカウント"></a>
<div class ="menu">
<table>
<tr>
<td><a class="button2 " title="閲覧ページです。" href="/CAP/T_ViewServlet" ><div class="eyes"><img src ="images/eyes.png" alt ="閲覧"></div></a></td>
<td><a class="button3" title="顔文字集計ページです。" href="/CAP/FaceCollectServlet"><div class ="smile"><img src ="images/smile.png" alt ="顔文字"></div></a></td>
</tr>
</table>
</div>
<footer class ="footer">
<a class="a" href="/CAP/LogoutServlet">ログアウト</a>
	<p class ="copyright">&copy:Copyright MINNKUDA . All rights reserved.</p>
</footer>
</body>
</html>