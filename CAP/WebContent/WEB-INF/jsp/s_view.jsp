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
  <header>
		  <hr>
		<h1 class ="logo"><a href="s_MenuServlet"><img src ="images/header.png" alt ="みんなの気持ち教えてくだサイト"></a></h1>
		<ul class="menu">
			<li><a href="/CAP/S_PostServlet">つぶやき投稿</a></li>
			<li><a href="/CAP/S_MenuServlet">一覧</a></li>
		</ul><br>
  </header>

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
		<h2 id="titleName">気持ち　投稿閲覧</h2>
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
  <div class=modal>
		<div class="modal-inner">
		  <h2>顔文字投稿</h2>
			<div class="close-btn" id="">
				<i class="fas fa-times"></i>
			</div>
			<div class=mini-q>
				<div class="questionnaire"> ここにアンケート名を入力</div><br>
			<div class=mini-wrapper1>
				<div class=mini-wrapper2>
					<h3 class="check_title">理解度</h3>
					<div class=FaceMark>
						<input type="radio" name="comp" value=1><label class="margin">good</label>
						<input type="radio" name="comp" value=2><label class="margin">soso</label>
						<input type="radio" name="comp" value=3><label class="margin">bad</label>
						</div>
					<br><textarea class="q_text"></textarea>
				</div>
				<div class="clear"></div>
				<div class=mini-wrapper3>
					<h3 class="check_title">気持ち</h3>
					<div class=FaceMark>
						<input type="radio" name="mental" value=1><label class="margin">good</label>
						<input type="radio" name="mental" value=2><label class="margin">soso</label>
						<input type="radio" name="mental" value=3><label class="margin">bad</label>
					</div>
					<br><textarea class="q_text"></textarea>
				</div>
			</div>
			<div class=mini_center>
				<input type="submit" name="送信">
			</div>
		</div>
		</div>
		<div class="modal-background" id="js-black-bg"></div>
  </div>
</body>
</html>