var point;
$(document).ready(function(){
	point=getCookie('point');//获取用户userinfo from cookie
	$('.integral_num').html(point);
});

