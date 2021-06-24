<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>みんなの気持ち教えてくだサイト</title>
<link rel ="stylesheet" href ="css/common.css">
<link rel ="stylesheet" href ="css/faceview.css">
</head>
<body>
<header class="header">
  <a href="${menu.menu}"></a>
</header>
<ul id="g-nav">
<li class="nav-item"><a href="/CAP/T_ViewServlet"> 　　つぶやき投稿　　</a></li>
<li class="nav-item"><a href="/CAP/T_MenuServlet">　　　　一覧　　　　</a></li>
<li class="nav-item"><a href="/CAP/FaceCheckServlet">FaceCheckServletに飛ぶ</a></li>
</ul>
<div class="wrapper">
<div class = "wrapper1">
	<div class = "wrapper2">
			<ul>

				<li><input type="radio" name="genre" value="1" id="ALL "><label for="ALL" class="tag"><a href="/CAP/FaceCollectServlet">全体</a></label></li>
				<li><input type="radio" name="genre" value="2" id="rikaido"><label for="rikaido"  class="tag"><a href="/CAP/FaceCollectServlet2">理解度（個人）</a></label></li>
				<li><input type="radio" name="genre" value="3" id="kimoti"><label for="kimoti" class="tag"><a href="/CAP/FaceCollectServlet3">気持ち（個人）</a></label></li>
			</ul>
	</div>
	<div class = wrapper3>


		<h2>理解度</h2>


 		<!-- 理解度のグラフ -->
			  <input type="hidden" id="good" value="${FCList.get(0).facemark_good}"> <input type="hidden" id="soso"
				value="${FCList.get(1).facemark_soso}"> <input type="hidden"
				id="bad" value="${FCList.get(2).facemark_bad}">

			<canvas id="myPieChart"></canvas>
			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>
			<script>
				var ctx = document.getElementById("myPieChart");
				var good = document.getElementById("good").value;
				var soso = document.getElementById("soso").value;
				var bad = document.getElementById("bad").value;
				console.log("よい = " + good);
				console.log("普通 = " + soso);
				console.log("悪い = " + bad);

				var myPieChart = new Chart(ctx,
						{
							type : 'pie',
							data : {
								labels : [ "good", "soso", "bad" ],
								datasets : [ {
									backgroundColor : [ "#BB5179", "#FAFF67",
											"#58A27C" ],
									data : [ good, soso, bad ]
								} ]
							},
							options : {
								title : {
									display : true,
									text : '理解度割合'
								}
							}
						});
			</script>
	</div>



	<div class = wrapper4>
		<h2>メンタル</h2>
		<!-- メンタルのグラフ -->


			<input type="hidden" id="good2" value="${FMList.get(0).facemark_good}"> <input type="hidden" id="soso2"
				value="${FMList.get(1).facemark_soso}"> <input type="hidden"
				id="bad2" value="${FMList.get(2).facemark_bad}">

			<canvas id="myPieChart2"></canvas>
			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>
			<script>
				var ctx = document.getElementById("myPieChart2");
				var good2 = document.getElementById("good2").value;
				var soso2 = document.getElementById("soso2").value;
				var bad2 = document.getElementById("bad2").value;
				console.log("よい = " + good2);
				console.log("普通 = " + soso2);
				console.log("悪い = " + bad2);

				var myPieChart = new Chart(ctx,
						{
							type : 'pie',
							data : {
								labels : [ "good", "soso", "bad" ],
								datasets : [ {
									backgroundColor : [ "#BB5179", "#FAFF67",
											"#58A27C" ],
									data : [ good2, soso2, bad2 ]
								} ]
							},
							options : {
								title : {
									display : true,
									text : '理解度割合'
								}
							}
						});
			</script>

	</div>
</div>
</div>


  <br>
  <footer class="footer2">
		<a href="/CAP/LogoutServlet">ログアウト</a>
		 </footer>
			<p class="copyright">&copy:Copyright MINNKUDA . All rights reserved.</p>

	</ul>


</body>
</html>