package com.zx.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zx.Pojo.Articel;
import com.zx.Pojo.Comment;
import com.zx.Pojo.Message;
import com.zx.Pojo.Pageinfo;
import com.zx.Service.CommentService;
@RestController
public class CommentController {
	private CommentService commentService;
	@RequestMapping("/getAllComment")
	public Pageinfo getAllComment(@RequestParam(value="articelId") Integer articelId,@RequestParam(value="page",defaultValue="1") String page){
		Articel al=new Articel();
		al.setId(articelId);
		Integer count=commentService.getAllcommentCount(al);
		Pageinfo pi=initpage(count, page);
		if(Integer.parseInt(page) >pi.getLastpage())
		{
			pi.setPagenum(pi.getLastpage());
		}
		pi.setCondarticel(al);
		pi.setBegin((pi.getPagenum()-1)*pi.getShownum());
		pi.setEnd(pi.getBegin()+pi.getShownum());
		List result=commentService.getAllcomment(pi);
		pi.setResult(result);
		return pi;
	}
	@RequestMapping("/sendComment/{articelId}/{userId}/{comment}")
	public Message sendComment(@PathVariable(value = "articelId") Integer articelId,@PathVariable(value = "userId") Integer userId,@PathVariable(value = "comment") String comment)
	{
		Comment com=new Comment();
		com.setArticelId(articelId);
		com.setUserId(userId);
		com.setComment(comment);
		com.setDate(new Date());
		boolean result=commentService.saveComment(com);
		if(result)
		{
			return new Message("success", "评论成功！",new Date());
		}else
		{
			return new Message("fail", "评论失败！",new Date());
		}
	}
	
	@RequestMapping("/getCommentByarticelid/{articelId}")
	public List<Comment> getCommentByarticelid(@PathVariable(value = "articelId") String articelId)
	{
		return commentService.getcommentByarticelId(articelId);
	}
	
	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	
	//页面初始化
	public Pageinfo initpage(Integer datanum,String page)
	{
		Pageinfo pageif=new Pageinfo();
		int pageshownum=10;//每页展示数
		pageif.setShownum(pageshownum);
		pageif.setFirstpage(1);
		Integer allpage=(datanum>0)?(((datanum)%pageshownum==0)?(datanum/pageshownum):(datanum/pageshownum)+1):1;
		pageif.setAllpage(allpage);
		pageif.setLastpage(allpage);
		Integer pagenum=0;
		
		if(page==null)
		{
			pageif.setPagenum(1);
		}else
		{
			pagenum=Integer.parseInt(page);
			pageif.setPagenum(pagenum);
		}
		pageif.setPrev((pageif.getPagenum()-1)>0?pageif.getPagenum()-1:1);
		pageif.setNext((pageif.getPagenum()+1)<allpage?pageif.getPagenum()+1:allpage);
		String pageStr="";
		if(pagenum-3<=1||allpage<=7)
		{
			for (int i = 1; i <= ((allpage>7)?7:allpage); i++) {
				if(i==((allpage>7)?7:allpage))
				{
					pageStr+=i;
				}else
				{
					pageStr+=i+",";
				}
			}
			if(allpage>7)
			{
				pageStr+=",...";
			}
		}else
		{
			pageStr+="...,";
			int num=((((pagenum+3>allpage)?allpage:pagenum)>3)?3:((pagenum+3>allpage)?allpage:pagenum));
			int cnum=(num+pagenum)>allpage?(allpage-pagenum):num;
			for (int i = cnum-7; i <=cnum; i++) {
				if(i==cnum)
				{
					if(cnum+pagenum==allpage)
					{
						pageStr+=(pagenum+i);
					}else
					{
						pageStr+=(pagenum+i)+",...";
					}
				}else
				{
					pageStr+=(pagenum+i)+",";
				}
			}
		}
		pageif.setPageStr(pageStr.split(","));
		return pageif;
	}
	@RequestMapping("/deleteCom")
	public Message deleteCom(@RequestParam(value="commentId") String commentId)
	{
		int result=commentService.deleteComment(commentId);
		if(result>0)
		{
			return new Message("success","删除成功！",new Date());
		}else
		{
			return new Message("fail","删除失败！",new Date());
		}
	}
}
