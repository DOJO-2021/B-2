<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link href="https://use.fontawesome.com/releases/v5.0.8/css/all.css" rel="stylesheet"  type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>つぶやき投稿閲覧＜受講生用＞</title>
<link rel ="stylesheet" href ="css/common.css">
<link rel ="stylesheet" href ="css/s_view.css">
</head>
<body>
  <header class="header">
  </header>
		<ul id="g-nav">
			<li class="nav-item"><a href="/CAP/S_PostServlet">つぶやき投稿</a></li>
			<li class="nav-item"><a href="/CAP/S_MenuServlet">　　一覧　　</a></li>
			 <li class="nav-item"><a href="トップページへ">トップページ</a></li>
		</ul><br>
	<h2 id="titleName">気持ち　投稿閲覧</h2>
  <div class = "wrapper1">
	<div class = "wrapper2">
			<ul>
				<c:forEach var="a" items="${GenreList}">
					<li>
						<input type="radio" name="genre" id="${a.genre_id}" class="${a.genre_name}">
						<label for="${a.genre_id}" class="tag">${a.genre_name}</label>
					</li>
				</c:forEach>
			</ul>
	</div>
	<div class = wrapper3>

			<ul class="text">
				<c:forEach var="b" items="${PostList}">
					<c:forEach var="c" items="${StampList}">
							<input  id="${b.post_id}" class="${b.post_id}" name="post_genre${b.post_id}" type="hidden" value="${b.genre_id}">
							<li  id="genre_id${b.post_id}">
								<div id="menu-btn${b.post_id}" class="menu-btn"></div>
								<div id="menu-content${b.post_id}" class="menu-content">
									<ul>
										<li><form method="POST" action="/CAP/DeleteServlet" >
										<input type="hidden" name=post_id value="${b.post_id}">
										<input type="submit" name=delete value=投稿削除>
										</form></li>
									</ul>
								</div>
								 ${b.post_date} - ${b.post_time}<br>${b.post_text}<br>${c.browsing_b_stamp}<br>
								<button id="js-show-popup${b.post_id}" class="${b.post_text}">返信</button>
							</li>
					</c:forEach>
					<div class="popup" id="js-popup${b.post_id}">
				  		<div class="popup-inner">
				    		<div class="close-btn" id="js-close-btn${b.post_id}">
								<i class="fas fa-times"></i>
							</div>
								<p id="nowPOST${b.post_id}" class="center">（投稿内容）</p><br>
							<div  class=commentList>
								<c:forEach var="d" items="${CommentList}" >
									<div id="VorH${b.post_id}${d.browsing_c_id}">
										<div id="cId${b.post_id}${d.browsing_c_id}" class="${d.post_id}">
											<p class=comment>${d.browsing_c_comment}</p>
										</div>
									</div>
									<script defer>
									//投稿に紐づいたコメントを表示
									document.getElementById("js-show-popup${b.post_id}").addEventListener('click',function(){
										let postId = $('input[name="post_genre${b.post_id}"]').attr('id');
										let composId = $("#cId${b.post_id}${d.browsing_c_id}").attr("class");

											$('#VorH${b.post_id}${d.browsing_c_id}').removeClass("Visible");
											$('#VorH${b.post_id}${d.browsing_c_id}').removeClass("Hidden");
										if(postId === composId){
											$('#VorH${b.post_id}${d.browsing_c_id}').addClass("Visible");
										}else{
											$('#VorH${b.post_id}${d.browsing_c_id}').addClass("Hidden");
										}
									});
									</script>
								</c:forEach>
							</div>
							<form method="POST" action="/CAP/S_ViewServlet">
								<input type="hidden" name="post_id" value="${b.post_id}">
								<p class="textp"><textarea cols="60" rows="2" wrap="soft" name="comment" class="textarea"></textarea>
								<br><input type="submit" value="送信"></p>
							</form>
				 		</div>
				  		<div class="black-background" id="js-black-bg"></div>
					</div>
					<script defer>
						//jQuery無しでコメントオンオフ切り替え
						document.getElementById("js-show-popup${b.post_id}").addEventListener('click',function(){
							document.getElementById('js-popup${b.post_id}').classList.toggle('is-show');
							//コメントの投稿をタイトルに表示
							let text = $('#js-show-popup${b.post_id}').attr('class');
							document.getElementById('nowPOST${b.post_id}').textContent =(text);
						});
						document.getElementById("js-close-btn${b.post_id}").addEventListener('click',function(){
							document.getElementById('js-popup${b.post_id}').classList.toggle('is-show');
						});
						//jQueryでハンバーガーボタン切り替え
						$(function(){
							$("#menu-btn${b.post_id}").click(function(){
								$(this).toggleClass("on");
								$("#menu-content${b.post_id}").toggleClass("menu-appearance");
							});
						});
						//ジャンル選択
						$(function(){
							$('input[name="genre"]:radio').change(function(){
								var radiogenre = $('input[name="genre"]:checked').attr("id");
								var postgenre = $('input[name="post_genre${b.post_id}"]').val();
									$('#genre_id${b.post_id}').removeClass("Visible");
									$('#genre_id${b.post_id}').removeClass("Hidden");
								if(radiogenre == postgenre){
									$('#genre_id${b.post_id}').addClass("Visible");
								} else {
									$('#genre_id${b.post_id}').addClass("Hidden");
								}
							});
						});
						//最初のジャンル選択
						window.addEventListener( 'DOMContentLoaded' , function(){
							let elements = document.querySelectorAll("input[name=genre]");
							elements[0].checked = true;
							var radiogenre = $('input[name="genre"]:checked').attr("id");
							var postgenre = $('input[name="post_genre${b.post_id}"]').val();
							if(radiogenre == postgenre){
								$('#genre_id${b.post_id}').addClass("Visible");
							} else {
								$('#genre_id${b.post_id}').addClass("Hidden");
							}
						});
					</script>
				</c:forEach>
			</ul>
	</div>
</div>
					<script>
					window.addEventListener( 'DOMContentLoaded' , function(){
						const genreName = $('input[name=genre]:checked').attr("class");
						console.log(genreName);
						document.getElementById('titleName').textContent =`\${genreName}　投稿一覧`;

					});

					$(function(){
						$('input[name="genre"]:radio').change(function(){
							const genreName = $('input[name=genre]:checked').attr("class");
							console.log(genreName);
							document.getElementById('titleName').textContent =`\${genreName}　投稿一覧`;
						});
					});
					</script>
<script type="text/javascript" src="/CAP/js/s_view.js"></script>
  <br>
  <footer class ="footer2">
	<p>&copy:Copyright MINNKUDA . All rights reserved.</p>
<a href="/CAP/LogoutServlet" style="margin-left:820px;">ログアウト</a>
  </footer>
   <div class="modal" id="modal">
		<div class="modal-inner">
		  <h2>顔文字投稿</h2>
	<!--	<div class="close-btn" id="">
				<i class="fas fa-times"></i>
			</div> -->
		<form method="POST" action="/CAP/FacePostServlet">
			<div class=mini-q>
				<c:forEach var="e" items="${QList}">
					<div class="questionnaire" id="${e.q_id}"> ${e.q_name}</div><br>
					<input type="hidden" name="q_id" value="${e.q_id}">
				</c:forEach>
			<div class=mini-wrapper1>
				<div class=mini-wrapper2>
					<h3 class="check_title">理解度</h3>
					<div class=FaceMark>
						<input type="radio" name="C_COMPREHENSION_ID" id=comp1 value=1><label for=comp1 class="margin"><img src="/CAP/images/kaomozi1.png" onmouseover="this.src='CAP/images/kao1.png'" onmouseout="this.src='CAP/images/kaomozi1.png'" width="50" height="50"></label>
						<input type="radio" name="C_COMPREHENSION_ID" id=comp2 value=2><label for=comp2 class="margin"><img src="/CAP/images/kaomozi2.png" onmouseover="this.src='CAP/images/kao2.png'"width="50" height="50"></label>
						<input type="radio" name="C_COMPREHENSION_ID" id=comp3 value=3><label for=comp3 class="margin"><img src="/CAP/images/kaomozi3.png" onmouseover="this.src='CAP/images/kao3.png'"width="50" height="50"></label>
						</div>
					<br><textarea class="q_text" name="C_COMPREHENSION_TEXT"></textarea>
				</div>
				<div class="clear"></div>
				<div class=mini-wrapper3>
					<h3 class="check_title">気持ち</h3>
					<div class=FaceMark>
						<input type="radio" name="C_MENTAL_ID" value=1 id=mental1><label for=mental1 class="margin"><img src="/CAP/images/kaomozi1.png" width="50" height="50"></label>
						<input type="radio" name="C_MENTAL_ID" value=2 id=mental2><label for=mental2 class="margin"><img src="/CAP/images/kaomozi2.png" width="50" height="50"></label>
						<input type="radio" name="C_MENTAL_ID" value=3 id=mental3><label for=mental3 class="margin"><img src="/CAP/images/kaomozi3.png" width="50" height="50"></label>
					</div>
					<br><textarea class="q_text" name="C_MENTAL_TEXT"></textarea>
				</div>
			</div>
			<div class=mini_center>
				<input type="submit" name="送信">
			</div>
			</div>
		</form>
		</div>
		<div class="modal-background" id="js-black-bg"></div>
  </div>
  <script>
  	'use strict';
 	//未回答の投稿があった場合最新のものを表示
  	window.addEventListener( 'DOMContentLoaded' , function(){
//  		console.log("script start");
		const id = ${QList.get(0).q_id};
//		console.log("console q_id="+ id);
//		console.log("console q_id="+ typeof(id));
		if(!(id === 0) || !(id === undefined)){
			document.getElementById('modal').classList.toggle('is-show_modal');
		}
  	});
  </script>
</body>
</html>