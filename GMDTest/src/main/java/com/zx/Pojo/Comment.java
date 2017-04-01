package com.zx.Pojo;

import java.util.Date;

public class Comment {
	private Integer id;
	private Integer articelId;
	private Integer userId;
	private String comment;
	private Date date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getArticelId() {
		return articelId;
	}
	public void setArticelId(Integer articelId) {
		this.articelId = articelId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Comment(Integer id, Integer articelId, Integer userId,
			String comment, Date date) {
		super();
		this.id = id;
		this.articelId = articelId;
		this.userId = userId;
		this.comment = comment;
		this.date = date;
	}
	public Comment() {
		super();
	}
}
