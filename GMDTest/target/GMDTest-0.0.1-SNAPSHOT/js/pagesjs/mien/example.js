var userid;
$(document).ready(function(){
	userid=getCookie('userid');//获取用户userid from cookie
	loadzb();
	loadbanner();
});
//加载直播链接
function loadzb()
{
	$.ajax({
		url:'/getArticelsBymodel/7/'+(userid==null?0:userid),
		async:true,
		success:function(data)
		{
			$(data).each(function(index,element){
				var Data = data[index];
				$('#zb').attr('href',Data.outUrl);
			});
		}
	});
}
//加载banner图
function loadbanner()
{
	$.ajax({
		url:'/getAllbanner?belong=1',
		async:true,
		success:function(data)
		{
			$(data).each(function(index,element){
				var Data = data[index];
				console.log(Data);
				console.log($('.slides li a img')[index+1].src);
				$('.slides li a img')[index+1].src='/readpicFile?filepath='+Data.bannerPath;
			});
		}
	});
}