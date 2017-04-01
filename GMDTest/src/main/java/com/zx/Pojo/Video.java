package com.zx.Pojo;

public class Video {
	private Integer id;
	private String videoName;
	private String videoPath;
	private Long filesize;
	private String title;
	private Integer articelId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getVideoPath() {
		return videoPath;
	}
	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}
	
	public Long getFilesize() {
		return filesize;
	}
	public void setFilesize(Long filesize) {
		this.filesize = filesize;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getArticelId() {
		return articelId;
	}
	public void setArticelId(Integer articelId) {
		this.articelId = articelId;
	}
	public Video(Integer id, String videoName, String videoPath) {
		super();
		this.id = id;
		this.videoName = videoName;
		this.videoPath = videoPath;
	}
	public Video() {
		super();
	}
	
}
