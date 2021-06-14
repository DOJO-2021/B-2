'use strict';

//jQuery無しでコメントオンオフ切り替え
const btn = document.getElementById("js-show-popup");
const closeBtn = document.getElementById('js-close-btn');
const popup = document.getElementById('js-popup');

btn.addEventListener('click',function(){
	popup.classList.toggle('is-show');
});

closeBtn.addEventListener('click',function(){
    popup.classList.toggle('is-show');
});

//jQueryでハンバーガーボタン切り替え
$(function(){
	$("#menu-btn").click(function(){
		$(this).toggleClass("on");
		$("#menu-content").toggleClass("menu-appearance");
	});
});
