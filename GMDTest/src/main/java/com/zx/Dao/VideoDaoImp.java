package com.zx.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.zx.Pojo.Banner;
import com.zx.Pojo.Video;

public class VideoDaoImp extends SqlSessionDaoSupport{
	public List<Video> getallVideo()
	{
		SqlSession session=getSqlSession();
		List<Video> list=session.selectList("selectAllvideo");
		return list;
	}
	
	public int deleteVideo(String id)
	{
		SqlSession session=getSqlSession();
		return session.delete("deleteVideo", id);
	}
	public int updateArticel(String id)
	{
		SqlSession session=getSqlSession();
		return session.update("updateArticelByfileid", id);
	}
	public int saveVideo(Video video)
	{
		SqlSession session=getSqlSession();
		return session.insert("saveVideo", video);
	}
	
	public Video getVideoByname(Video video)
	{
		SqlSession session=getSqlSession();
		List<Video> list=session.selectList("selectVideoByname",video);
		return list.size()>0?list.get(0):null;
	}
	
	public Video getVideoByid(String id)
	{
		SqlSession session=getSqlSession();
		List<Video> list=session.selectList("selectVideoByid",id);
		return list.size()>0?list.get(0):null;
	}
}
