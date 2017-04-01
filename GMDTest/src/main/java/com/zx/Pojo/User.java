package com.zx.Pojo;

import java.util.Date;

public class User {
	private Integer id;
	private String UserName; //用户名即电话号
	private String Password;
	private String code;
	private Integer Point; // 积分
	private String lastPointDate;
	private String niceName;
	private String trueName;
	private Integer sex;
	private String birthday;
	private String community; //所在社区
	private String detailAddress;//详细地址
	private String checkcode;
	private Integer statue;
	private String loginPointDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getPoint() {
		return Point;
	}
	public void setPoint(Integer point) {
		Point = point;
	}
	public String getNiceName() {
		return niceName;
	}
	public void setNiceName(String niceName) {
		this.niceName = niceName;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getCommunity() {
		return community;
	}
	public void setCommunity(String community) {
		this.community = community;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public User() {
		super();
	}
	public String getLastPointDate() {
		return lastPointDate;
	}
	public void setLastPointDate(String lastPointDate) {
		this.lastPointDate = lastPointDate;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCheckcode() {
		return checkcode;
	}
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	public User(Integer id, String userName, String password, String code,
			Integer point, String lastPointDate, String niceName,
			String trueName, Integer sex, String birthday, String community,
			String detailAddress) {
		super();
		this.id = id;
		UserName = userName;
		Password = password;
		this.code = code;
		Point = point;
		this.lastPointDate = lastPointDate;
		this.niceName = niceName;
		this.trueName = trueName;
		this.sex = sex;
		this.birthday = birthday;
		this.community = community;
		this.detailAddress = detailAddress;
	}
	public Integer getStatue() {
		return statue;
	}
	public void setStatue(Integer statue) {
		this.statue = statue;
	}
	public String getLoginPointDate() {
		return loginPointDate;
	}
	public void setLoginPointDate(String loginPointDate) {
		this.loginPointDate = loginPointDate;
	}
	
}
