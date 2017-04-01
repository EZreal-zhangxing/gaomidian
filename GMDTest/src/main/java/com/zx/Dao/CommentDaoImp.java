package com.zx.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.zx.Pojo.Articel;
import com.zx.Pojo.Comment;
import com.zx.Pojo.Pageinfo;

public class CommentDaoImp extends SqlSessionDaoSupport {
	public int saveComment(Comment com)
	{
		SqlSession session=this.getSqlSession();
		return session.insert("saveComment",com);
	}
	
	public int deleteComment(String commentId)
	{
		SqlSession session=this.getSqlSession();
		return session.delete("delComment",commentId);
	}
	public List getAllcomment(Pageinfo pi)
	{
		SqlSession session=this.getSqlSession();
		return session.selectList("getAllComment",pi);
	}
	
	public Integer getAllcommentCount(Articel al)
	{
		SqlSession session=this.getSqlSession();
		List list=session.selectList("getAllcount",al);
		return list.size()>0?(Integer)list.get(0):null;
	}
	
	public List getcommentByarticelId(String articelId)
	{
		SqlSession session=this.getSqlSession();
		return session.selectList("getCommentByid",articelId);
	}
}
