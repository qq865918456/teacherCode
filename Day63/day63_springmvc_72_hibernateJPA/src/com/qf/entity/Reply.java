package com.qf.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Table;

@Table(name="t_reply")
@Entity
public class Reply {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	/**
	 * 回复内容
	 */
	private String content; 
	
	/**
	 * 回复人
	 */
	@ManyToOne
	@JoinColumn(name="user_id")
	private User replyUser;
	
	/**
	 * 回复时间
	 */
	@Column(name="create_time")
	private Date createDate;
	
	/**
	 *回复给那个帖子
	 */
	@ManyToOne
	@JoinColumn(name="topic_id")
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
