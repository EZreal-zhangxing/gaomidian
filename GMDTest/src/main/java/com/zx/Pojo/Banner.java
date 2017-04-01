package com.zx.Pojo;

public class Banner {
	private Integer id;
	private String bannerName;
	private String bannerPath;
	private Integer belong;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBannerName() {
		return bannerName;
	}
	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}
	public String getBannerPath() {
		return bannerPath;
	}
	public void setBannerPath(String bannerPath) {
		this.bannerPath = bannerPath;
	}
	public Integer getBelong() {
		return belong;
	}
	public void setBelong(Integer belong) {
		this.belong = belong;
	}
	public Banner(Integer id, String bannerName, String bannerPath) {
		super();
		this.id = id;
		this.bannerName = bannerName;
		this.bannerPath = bannerPath;
	}
	public Banner() {
		super();
	}
	
}
