<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>みんなの気持ち教えてくだサイト受講者用</title>
<link rel ="stylesheet" href ="css/s_menu.css">
</head>
<body>
<header class ="header">
<h1 class ="logo"><!-- a href="S_MenuServlet" --><img src ="images/logo_ver3.png" alt ="みんなの気持ち教えてくだサイト"></h1>
</header>
<hr>
<a class="icon" href="/CAP/SigninServlet"><img src ="images/icon.png" alt ="アカウント"></a>
<div class="menu">
<table>
<tr>
<td><a class="button2" title="投稿ページです。" href="/CAP/S_PostServlet" ><div class="write"><img src ="images/write.png" alt ="投稿"></div></a></td>
<td><a class="button3" title="閲覧ページです。" href="/CAP/S_ViewServlet" ><div class="eyes"><img src ="images/eyes.png" alt ="閲覧"></div></a></td>
</tr>
</table>
</div>
<footer class ="footer">
<a href="/CAP/LogoutServlet">ログアウト</a>
</footer>
</body>
</html>