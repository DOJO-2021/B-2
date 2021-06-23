<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>みんなの気持ち教えてくだサイト</title>
<link rel ="stylesheet" href ="css/common.css">
<link rel ="stylesheet" href ="css/error.css">
</head>
<body>
<header class="header">
	<h1>
			<a href="${menu.menu}"><img src="images/logo5.png" alt="みんなの気持ち教えてくだサイト" class="images"></a>
		</h1>
</header>
<main>
<hr>
	<h1 class="result"><c:out value="${result.title}" /></h1>
	<p class="result"><c:out value="${result.message}" /></p>
	<div class="result"><a href="${result.backTo}">戻る</a></div>
</main>
<footer>
</footer>
</body>
</html>