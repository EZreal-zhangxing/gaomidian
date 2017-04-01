package com.zx.Service;

import java.util.List;

import com.zx.Dao.VideoDaoImp;
import com.zx.Pojo.Banner;
import com.zx.Pojo.Video;

public class VideoService {
	private VideoDaoImp videoDaoimp;
	public boolean saveVideo(Video video)
	{
		int result=videoDaoimp.saveVideo(video);
		if(result>0)
		{
			return true;
		}else
		{
			return false;
		}
		
	}
	public Video getVideoByname(Video video)
	{
		return videoDaoimp.getVideoByname(video);
	}
	
	public List<Video> getAllvideo()
	{
		return videoDaoimp.getallVideo();
	}
	public boolean deleteVideo(String id)
	{
		int result=videoDaoimp.deleteVideo(id);
		if(result>0)
		{
			videoDaoimp.updateArticel(id);
			return true;
		}else
		{
			return false;
		}
	}
	public VideoDaoImp getVideoDaoimp() {
		return videoDaoimp;
	}

	public void setVideoDaoimp(VideoDaoImp videoDaoimp) {
		this.videoDaoimp = videoDaoimp;
	}
	
	public Video getVideobyid(String id) {
		return videoDaoimp.getVideoByid(id);
	}
	
}
