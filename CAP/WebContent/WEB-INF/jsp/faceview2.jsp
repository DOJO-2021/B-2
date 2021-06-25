<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>みんくだ</title>


<link rel ="stylesheet" href ="css/t_common.css">
<link rel ="stylesheet" href ="css/faceview.css">
<link rel ="stylesheet" href ="css/faceview2.css">
</head>
<body>
<header class="header">
			<a href="${menu.menu}"><img src="images/logo6.png" alt="みんなの気持ち教えてくだサイト"></a>
</header>

<ul id="g-nav">
<li class="nav-item"><a href="/CAP/T_ViewServlet">みんくだ一覧</a></li>
<li class="nav-item"><a href="/CAP/FaceCheckServlet">顔文字チェック</a></li>
<li class="nav-item"><a href="/CAP/T_MenuServlet">メニューページ</a></li>
</ul>
<h1>顔文字集計(理解度個人)</h1>
<!-- ヘッダーメニュー -->


<form method="GET" action="FaceCollectServlet2.java">




  		<select name="q_id">
   			 <c:forEach var="f" items="${q_nameList}">
    			<option value="${f.q_name}">${f.q_name}</option>


			 </c:forEach>
 		</select>

	<!--  <script>
 		//アンケート選択
		$(function(){
			$('select[name="q_id"]').change(function(){
				var radiogenre = $('select[name="q_id"]').attr("id");
				var postgenre = $('select[name="post_genre${b.post_id}"]').val();
					$('#genre_id${b.post_id}').removeClass("Visible");
					$('#genre_id${b.post_id}').removeClass("Hidden");
				if(radiogenre == postgenre){
					$('#genre_id${b.post_id}').addClass("Visible");
				} else {
					$('#genre_id${b.post_id}').addClass("Hidden");
				}
			});
		});
  	</script>-->
</form>

<div class = "wrapper1">
	<div class = "wrapper2">
			<ul>

				<li><input type="radio" name="genre" value="1" id="ALL"><label for="ALL" class="tag"><a href="/CAP/FaceCollectServlet">全体</a></label></li>
				<li><input type="radio" name="genre" value="2" id=""><label for="rikaido"  class="tag"><a href="/CAP/FaceCollectServlet2">理解度（個人）</a></label></li>
				<li><input type="radio" name="genre" value="3" id="Java"><label for="kimoti" class="tag"><a href="/CAP/FaceCollectServlet3">気持ち（個人）</a></label></li>



			</ul>
	</div>

	<div class = "wrapper3">


	<c:forEach var="a" items="${alldataList}">
					<p>(名前)<c:out value="${a.l_name}" /><c:out value="${a.f_name}" /></p>

					<!-- 時間 -->
					<p>
						<c:out value="${a.c_date}" />
					</p>
					<!-- 理解度の顔文字 -->
					<img src="images/kao1.png" width="30" height="30"
						id="${a.c_comprehension_id}" />
					<!-- 理解度のテキスト -->
					<p>
						<c:out value="${a.c_comprehension_text}" />
					</p>







					<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
					<script>
						window.addEventListener('DOMContentLoaded', function() {
							let id = $('#${a.c_comprehension_id}').attr('id');
							console.log(id);

							if (id === '2') {
								$('#${a.c_comprehension_id}').attr('src',
										'images/kao2.png');
							} else if (id === '3') {
								$('#${a.c_comprehension_id}').attr('src',
										'images/kao3.png');
							}
						});
					</script>

		</c:forEach>


	</div>

</div>




  <br>
  <footer class="footer2">
		<a href="/CAP/LogoutServlet">ログアウト</a>
		</footer>
	<p class="copyright">&copy:Copyright MINNKUDA . All rights reserved.</p>


</body>
</html>