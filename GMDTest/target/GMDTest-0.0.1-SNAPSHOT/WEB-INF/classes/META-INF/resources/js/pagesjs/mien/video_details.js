var articelId;
var system; //1 安卓  2 IOS
$(document).ready(function(){
	articelId=getQueryString('articelId');//获取文章ID
	operationSystem();
	loadvideo();
});
var pagestr="";
function loadvideo()
{
	$.ajax({
		url:'/getArticelContent/'+articelId,
		async:true,
		success:function(data)
		{
			$(data).each(function(index,element){
				var Data = data[index];
				console.log(Data);
				console.log(Data.id);
				var time = new Date(Data.date).Format("yyyy-MM-dd");
				pagestr=pagestr+
					'<h1>'+Data.title+'</h1>'+
				    '<span class="publishTime">'+time+'</span>'+
				    '<div class="video_show" align="center">';
//				if(system==2)
//				{
					pagestr=pagestr+
					"<video id='example_video_1' class='video-js vjs-default-skin vjs-big-play-centered' controls preload='auto' width='512' height='512' data-setup='{}'>";
//					"<source src='http://vjs.zencdn.net/v/oceans.mp4' type='video/mp4' />"+
					if(getHz(Data.videoPath) == "mp4")
					{
						pagestr=pagestr+"<source src='"+Data.videoPath+"' type='video/mp4' />";						
					}else if(getHz(Data.videoPath) == "webm")
					{
						pagestr=pagestr+"<source src='"+Data.videoPath+"' type='video/webm' />";
					}else if(getHz(Data.videoPath) == "ogg")
					{
						pagestr=pagestr+"<source src='"+Data.videoPath+"' type='video/ogg' />";
					}
					pagestr=pagestr+
					"<track kind='captions' src='' srclang='en' label='English'></track><!--字幕 Tracks need an ending tag thanks to IE9 -->"+
					"<track kind='subtitles' src='' srclang='en' label='English'></track><!--字幕 Tracks need an ending tag thanks to IE9 -->"+
					"</video>";
//				}else
//				{
//					pagestr=pagestr+'<video class="video-source" preload="auto"  x5-video-player-fullscreen="true" x5-video-orientation="h5" x5-video-player-type="h5" width="512"　height="512" controls style="object-fit:fill" x-webkit-airplay="true" webkit-playsinline="true">' +
//					"<source src='/readpicFile?filepath="+Data.videoPath+"' type='video/mp4' />"+
//					"<source src='/readpicFile?filepath="+Data.videoPath+"' type='video/webm' />"+
//					"<source src='/readpicFile?filepath="+Data.videoPath+"' type='video/ogg' />"+
//					'</video>';
//				}
				pagestr+='</div>';
			});
			loadComment();
		}
	});
}
function loadComment(){
	$.ajax({
		url:'/getCommentByarticelid/'+articelId,
		async:true,
		success:function(data)
		{
			pagestr=pagestr+
			'<div class="talk">'+
		    	'<p class="talk_num">共'+data[0].Num+'条评论</p>'+
		        '<p class="talk_time">按回复时间排序<a class=""></a></p>'+
		    '</div>';
			$(data).each(function(index,element){
				var Data = data[index];
				pagestr=pagestr+
				'<div class="remark">'+
			    	'<div class="remark_img"><img src="../images/talk_head.png" /></div>'+
			        '<div class="remark_word">'+
			        	'<p class="remark_name">'+Data.niceName+'<span>'+(index+1)+'楼</span></p>'+
			            '<p class="remark_saying">'+Data.comment+'</p>'+
			            '<p class="remark_time">'+Data.Date+'</p>'+
			        '</div>'+
			    '</div>';
			});
			$('#content').append(pagestr);
		}
	});
}

function sendmsg()
{
	var youinput=$('#youinput').val();
	console.log(youinput);
	
	var userid=getCookie('userid');//获取用户userid from cookie
	if(userid == null)
	{
		alert('请先登陆！');
		window.location.href="/life/login.html?addressUrl=1";
	}else
	{
		$.ajax({
			url:'/sendComment/'+articelId+'/'+userid+'/'+youinput,
			async:true,
			success:function(data)
			{
				if(data.code == 'success')
 				{
//					alert(data.code+":"+data.message);
					window.location.reload();
 				}else{
 					alert(data.code+":"+data.message);
 				}
			}
		});
	}
}

function operationSystem()
{
	var u = navigator.userAgent;
	var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Adr') > -1; //android终端
	var isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/); //ios终端
	if(isAndroid)
	{
		system=1;
	}
	if(isiOS)
	{
		system=2;	
	}
//	alert('是否是Android：'+isAndroid);
//	alert('是否是iOS：'+isiOS);
}

function getHz(path)
{
	return path.substr(path.indexOf(".")+1,path.length);
}