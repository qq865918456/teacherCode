package com.qf.entity;

import java.util.Date;

public class Reply {

	private Integer id;
	
	/**
	 * 回复内容
	 */
	private String content; 
	
	/**
	 * 回复人
	 */
	private User replyUser;
	
	/**
	 * 回复时间
	 */
	private Date createDate;
	
	/**
	 *回复给那个帖子
	 */
	private Topic replyTopic;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getReplyUser() {
		return replyUser;
	}

	public void setReplyUser(User replyUser) {
		this.replyUser = replyUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Topic getReplyTopic() {
		return replyTopic;
	}

	public void setReplyTopic(Topic replyTopic) {
		this.replyTopic = replyTopic;
	}
	
	
}
