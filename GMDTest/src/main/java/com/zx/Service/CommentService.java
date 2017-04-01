package com.zx.Service;

import java.util.List;

import com.zx.Dao.CommentDaoImp;
import com.zx.Pojo.Articel;
import com.zx.Pojo.Comment;
import com.zx.Pojo.Pageinfo;

public class CommentService {
	private CommentDaoImp commentDaoImp;

	public boolean saveComment(Comment comment)
	{
		int result=commentDaoImp.saveComment(comment);
		if(result>0)
		{
			return true;
		}else
		{
			return false;
		}
	}
	public List getcommentByarticelId(String articelId)
	{
		return commentDaoImp.getcommentByarticelId(articelId);
	}
	
	public List getAllcomment(Pageinfo pi)
	{
		return commentDaoImp.getAllcomment(pi);
	}
	public Integer getAllcommentCount(Articel al)
	{
		return commentDaoImp.getAllcommentCount(al);
	}
	
	public int deleteComment(String commentid)
	{
		return commentDaoImp.deleteComment(commentid);
	}
	
	public CommentDaoImp getCommentDaoImp() {
		return commentDaoImp;
	}

	public void setCommentDaoImp(CommentDaoImp commentDaoImp) {
		this.commentDaoImp = commentDaoImp;
	}
	
}
