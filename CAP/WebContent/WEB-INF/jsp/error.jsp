<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>みんなの気持ち教えてくだサイト</title>
</head>
<body>
<header>
	<h1>みんなの気持ち教えてくだサイト</h1>
</header>
<main>
<hr>
	<h1><c:out value="${result.title}" /></h1>
	<p><c:out value="${result.message}" /></p>
	<a href="${result.backTo}">戻る</a>
</main>
<footer>
</footer>
</body>
</html>