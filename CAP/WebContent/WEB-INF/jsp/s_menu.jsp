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
<h1 class ="logo"><a href="t_MenuServlet"><img src ="images/header.png" alt ="みんなの気持ち教えてくだサイト"></a></h1>
</header>
<hr>
<a class="button1" href="/CAP/SigninServlet">アカウント</a>
<div class="menu">
<table>
<tr>
<td><a class="button2" href="/CAP/S_PostServlet" >投稿</a></td>
<td><a class="button3" href="/CAP/S_ViewServlet" >閲覧</a></td>
</tr>
</table>
</div>
<footer class ="footer">
<a href="/CAP/LogoutServlet">ログアウト</a>
</footer>
</body>
</html>