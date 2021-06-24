<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>みんくだ</title>
<link rel="stylesheet" href="css/mypage.css">
<link rel="stylesheet" href="css/common.css">
</head>
<body>
	<header>
	<a href="${menu.menu}"><img src="images/logo5.png" alt="みんなの気持ち教えてくだサイト" class="images"></a>
	</header>
	<main>
		<div class="box">
			<p class="boxtitle">-ACCOUNT-</p>
			<p class="hello">
				こんにちは、
				<c:out value="${cardList.get(0).user_l_name}" />
				<c:out value="${cardList.get(0).user_f_name}" />
				さん
			</p>
			<form method="POST" action="/CAP/MyPageServlet" id="form">
				<input type="hidden" name="user_l_name" id="result"
					value="${cardList.get(0).user_l_name}"> <input
					type="hidden" name="user_f_name" id="result"
					value="${cardList.get(0).user_f_name}"> <input
					type="hidden" name="user_password" id="result"
					value="${cardList.get(0).user_password}"> <input
					type="hidden" name="user_type" id="result"
					value="${cardList.get(0).user_type}">
							<p class="massage">☆秘密の質問の変更が可能です</p>
				<table class="form">
					<tr>
						<th>秘密の質問</th>
						<td><select name="QUESTIONS"
							id="${cardList.get(0).secret_id}">
								<option value="1">①出身地は？</option>
								<option value="2">②親の旧姓は？</option>
								<option value="3">③ペットの名前は？</option>
								<option value="4">④母校（小学校）の名前は？</option>
								<option value="5">⑤初めての海外旅行先は？</option>
						</select></td>
					</tr>
					<tr>
						<th>答え</th>
						<td><input type="text" name="ANSWER"
							value="${cardList[0].user_answer}"></td>
					</tr>
				</table>
				<input type="submit" name="OK" value="OK" class="mypage1"> <input
					type="reset" value="リセット" class="mypage1"><br> <a
					href="${menu.menu}">ホームに戻る</a>
			</form>
		</div>
	</main>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="/CAP/js/mypage.js"></script>
	<script>
		var QUESTIONS = document.getElementById("${cardList.get(0).secret_id}").id;
		var opt;
		switch (QUESTIONS) {
		case '1':
			opt = document.querySelector('option[value="1"]');
			break;
		case '2':
			opt = document.querySelector('option[value="2"]');
			break;
		case '3':
			opt = document.querySelector('option[value="3"]');
			break;
		case '4':
			opt = document.querySelector('option[value="4"]');
			break;
		case '5':
			opt = document.querySelector('option[value="5"]');
			break;
		}
		opt.selected = true;
	</script>
</body>
<p class="copyright">&copyCopyright MINNKUDA . All rights reserved.</p>
</html>