<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link href="https://use.fontawesome.com/releases/v5.0.8/css/all.css" rel="stylesheet"  type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>みんくだ-講師用-</title>
<link rel ="stylesheet" href ="css/common.css">
<link rel ="stylesheet" href ="css/t_view.css">
</head>
<main>

  <header>
  <a href="${menu.menu}"><img src="images/logo5.png" alt="みんなの気持ち教えてくだサイト" class="images"></a>
  </header>
		<ul id="g-nav">
			<li class="nav-item"><a href="/CAP/T_PostServlet">みんくだ投稿</a></li>
			<li class="nav-item"><a href="/CAP/T_ViewServlet">みんくだ一覧</a></li>
			 <li class="nav-item"><a href="/CAP/T_MenuServlet">トップページ</a></li>
		</ul>
<body>
<br>
<br>
	<h2 id="titleName">気持ち　投稿閲覧</h2>
<br>
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
								 ${b.post_date} - ${b.post_time}<br>${b.post_text}<br>
								<c:forEach var="z" items="${S_CountList}">
									<div style="display:inline-flex">
									<form method="POST" action="/CAP/T_Browsing_bsServlet" style="text-align:left;">
									<input type="hidden" id="count${b.post_id}${z.post_id}${z.browsing_b_stamp}" class="${z.count}" name="post_id" value="${z.post_id}">
									<input type="hidden" id="substp${b.post_id}${z.post_id}${z.browsing_b_stamp}" name="browsing_b_stamp" value="${z.browsing_b_stamp}">
									<span id="VorH${b.post_id}${z.post_id}${z.browsing_b_stamp}" class="" >
										<button style="background:#ffffff; border:none; padding:0;"  id="stp${b.post_id}${z.post_id}${z.browsing_b_stamp}" class="${z.browsing_b_stamp}">
												<input type="submit" value="+" style="background:#ffffff; border:none; padding:0;">
										</button>
									 		×${z.count}　
									</span>
								<script>
								//投稿に応じたスタンプのデータを出す
									 window.addEventListener( 'DOMContentLoaded' , function(){
										 let postId = $('input[name="post_genre${b.post_id}"]').attr('id');
										 let stpposId = $('#count${b.post_id}${z.post_id}${z.browsing_b_stamp}').val();
										 console.log(postId);
										 console.log(stpposId);

											$("#VorH${b.post_id}${z.post_id}${z.browsing_b_stamp}").removeClass("Visible_I");
											$("#VorH${b.post_id}${z.post_id}${z.browsing_b_stamp}").removeClass("Hidden");
										if(postId===stpposId){
											$("#VorH${b.post_id}${z.post_id}${z.browsing_b_stamp}").addClass("Visible_I");
										}else{
											$("#VorH${b.post_id}${z.post_id}${z.browsing_b_stamp}").addClass("Hidden");
										}
									})

								//投稿のスタンプを表示
									 window.addEventListener( 'DOMContentLoaded' , function(){
 											let stpId = $('#stp${b.post_id}${z.post_id}${z.browsing_b_stamp}').attr('class');
 										if( stpId === "1" ){
 											$('#stp${b.post_id}${z.post_id}${z.browsing_b_stamp}').append("<span>&#x1f604</span>");
 										} else if ( stpId === "2" ){
	 										$('#stp${b.post_id}${z.post_id}${z.browsing_b_stamp}').append("<span>&#x1f62d</span>");
		 								} else if ( stpId === "3" ){
	 										$('#stp${b.post_id}${z.post_id}${z.browsing_b_stamp}').append("<span>&#x1f44d</span>");
	 									}
 									});
							</script>
							</form>
							</div>
							</c:forEach>
								<br><button id="js-show-popup${b.post_id}" class="${b.post_text}" name="button">返信</button>
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
							<form method="POST" action="/CAP/T_ViewServlet">
								<input type="hidden" name="post_id" value="${b.post_id}">
								<p class="textp"><textarea cols="60" rows="2" wrap="soft" name="comment" class="textarea"></textarea>
								<br><input type="submit" value="送信" name="button"></p>
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
	<form method="POST" action="/CAP/T_AddGenreServlet">
		＋<input type="text" name="GenreName" size="14">
		<input type="SUBMIT" name="addgenre" value="作成">
	</form>
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
<script type="text/javascript" src="/CAP/js/t_view.js"></script>
  <br>
  <footer class ="footer2">
  <a href="/CAP/LogoutServlet" style="margin-left:820px;">ログアウト</a>
	<p>&copy:Copyright MINNKUDA . All rights reserved.</p>
  </footer>
  </main>
</body>
</html>