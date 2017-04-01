package com.zx.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zx.Pojo.Message;
import com.zx.Pojo.Video;
import com.zx.Service.EncoderHandler;
import com.zx.Service.VideoService;

@RestController
public class VoideController {
	private VideoService videoService;
	
	@RequestMapping("/getAllvideo")
	public List<Video> getAllvideo()
	{
		return videoService.getAllvideo();
	}
	@RequestMapping("/deleteVideo")
	public Message deleteVideo(@RequestParam(value="id") String id)
	{
		Video resuleVideo=videoService.getVideobyid(id);
		boolean reslue=videoService.deleteVideo(id);
		if(reslue)
		{
			if(resuleVideo!=null)
			{
				File file=new File(resuleVideo.getVideoPath());
				file.delete();
			}
			return new Message("success", "删除成功！", new Date());
		}else
		{
			return new Message("fail", "删除失败！", new Date());
		}
	}
	
	public Video saveVideo(MultipartFile file) throws IOException
	{
		Video video=new Video();
		video.setFilesize(file.getSize());
		String fileName=file.getOriginalFilename();
		EncoderHandler eh=new EncoderHandler();
		String file_path=getfilepath();
		File savefile=new File(file_path);
		if(!savefile.exists())
		{
			savefile.mkdirs();
		}
		if(!"".equals(fileName))
		{
			String hzname=fileName.substring(fileName.indexOf("."), fileName.length());
			String md5FileName=eh.encodeByMD5(fileName+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())); //文件名 加上 时间戳
			video.setVideoName(md5FileName+hzname);
			String save_file_path=file_path+"/"+md5FileName+hzname;
			File save_file_obje=new File(save_file_path);
			try {
				saveFile(save_file_obje,file.getInputStream());
			} catch (Exception e) {
//				return new Message("fail", "保存失败", new Date());
			}
			video.setVideoPath(save_file_path);
		}else
		{
			return null;
		}
		boolean reslue=videoService.saveVideo(video);
		if(reslue)
		{	
			return videoService.getVideoByname(video);
		}else
		{
			return null;
		}
	}
	@RequestMapping("/uploadVoide")
	public void uploadVoide(HttpServletResponse response,@RequestParam(value = "filepath")  MultipartFile file) throws IOException
	{
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		response.setCharacterEncoding("UTF-8");
//		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));
		PrintWriter bw=response.getWriter();
		Video video=new Video();
		video.setFilesize(file.getSize());
		String fileName=file.getOriginalFilename();
		EncoderHandler eh=new EncoderHandler();
		String file_path=getfilepath();
		File savefile=new File(file_path);
		if(!savefile.exists())
		{
			savefile.mkdirs();
		}
		boolean reslue=false;
		if(!"".equals(fileName))
		{
			String hzname=fileName.substring(fileName.indexOf("."), fileName.length());
			String md5FileName=eh.encodeByMD5(fileName+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())); //文件名 加上 时间戳
			video.setVideoName(md5FileName+hzname);
			String save_file_path=file_path+"/"+md5FileName+hzname;
			File save_file_obje=new File(save_file_path);
			try {
				saveFile(save_file_obje,file.getInputStream());
			} catch (Exception e) {
//				return new Message("fail", "保存失败", new Date());
			}
			video.setVideoPath(save_file_path);
			reslue=videoService.saveVideo(video);
		}	
		String html="<!DOCTYPE html><html lang='en'><head>" +
		"<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' /></head>" +
		"<title>上传结果</title>" +
		"<body onload=jump()>";
		if(reslue)
		{
			html+="上传成功！";
//			return new Message("success", "保存成功", new Date());
		}else
		{
			html+="上传失败！";
//			return new Message("fail", "保存失败", new Date());
		}
		html+="<a href='video.html'>返回</a> <b id='sec'></b>秒后跳转！";
		html+="</body><script>var i;var int;function jump(){i=3;" +
		"document.getElementById('sec').innerHTML=i;" +
		"int=window.setInterval('clock(i)',1000)} function clock(){i=i-1;if(i<0){window.clearInterval(int);window.location.href='video.html';}else{document.getElementById('sec').innerHTML=i;}}</script></html>";
		bw.write(html);
		bw.flush();
		bw.close();
	}
	public void saveFile(File file,InputStream is) throws IOException
	{
		FileOutputStream fos=new FileOutputStream(file);
		byte[] bytes=new byte[1024*1024];
		int len=0;
		while((len=is.read(bytes))!=-1)
		{
			fos.write(bytes, 0, len);
		}
		fos.flush();
		fos.close();
		is.close();
	}
	public String getfilepath() throws IOException
	{
		InputStream inStream=ShowArticelController.class.getClassLoader().getResourceAsStream("file.properties");
		Properties pro=new Properties();
		pro.load(inStream);
		String sysStr=System.getProperties().getProperty("os.name");
		if(sysStr.indexOf("Windows") != -1)
		{
			System.out.println(pro.getProperty("windows_video"));
			return pro.getProperty("windows_video");
		}else
		{
			System.out.println(pro.getProperty("linux_video"));
			return pro.getProperty("linux_video"); 
		}
	}
	public VideoService getVideoService() {
		return videoService;
	}
	public void setVideoService(VideoService videoService) {
		this.videoService = videoService;
	}
	
	
}
